package com.example.reply;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.post.Post;
import com.example.post.PostRepository;
import com.example.user.User;
import com.example.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {

	private final ReplyRepository replyRepository;
	private final ReplyVoterRepository replyVoterRepository;
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	
	/**
	 * 댓글 내용, 게시글 번호, 사용자 아이디를 전달받아서 새 댓글을 추가한다.
	 * @param content 댓글 내용
	 * @param postId 게시글 번호
	 * @param name 사용자 아이디
	 */
	public Reply createReply(String content, Long postId, String username) {
		Post post = postRepository.findById(postId).orElseThrow();
		User user = userRepository.findByUsername(username).orElseThrow();
		
		Reply reply = new Reply();
		reply.setContent(content);
		reply.setPost(post);
		reply.setUser(user);
		
		return replyRepository.save(reply);
	}

	public Reply getReply(Long replyId) {
		
		return replyRepository.findById(replyId).orElseThrow();
	}
	
	public void deleteReply(Reply reply) {
		replyRepository.delete(reply);
	}

	public void vote(Long replyId, String username) {
		Reply reply = replyRepository.findById(replyId).orElseThrow();
		User user = userRepository.findByUsername(username).orElseThrow();
		
		// 댓글 정보와 사용자 정보로 이 댓글에 이 사용자가 추천한 정보를 조회한다.
		Optional<ReplyVoter> optional = replyVoterRepository.findByReplyAndUser(reply, user);
		if (optional.isEmpty()) {	// 추천정보가 존재하지 않으면
			ReplyVoter voter = new ReplyVoter();	// 새 댓글추천 엔티티정보를 생성하고, 댓글정보와 사용자정보를 저장한 다음 저장시킨다.
			voter.setReply(reply);
			voter.setUser(user);
			replyVoterRepository.save(voter);
			
		} else {					// 추천정보가 존재하면
			ReplyVoter voter = optional.get();	// 위에서 조회한 Optional<ReplyVoter>에서 조회된  ReplyVoter를 꺼내고, 그 ReplyVoter를 전달해서 삭제시킨다.
			replyVoterRepository.delete(voter);
		}
	}

	public void modify(Reply reply, String content) {
		reply.setContent(content);
		replyRepository.save(reply);
	}
}
