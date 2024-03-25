package com.example.reply;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class ReplyController {

	private final ReplyService replyService;
	
	@PostMapping("/create/{postId}")
	public String create(@PathVariable("postId") Long postId, @RequestParam("content") String content, Principal principal) {
		
		Reply reply = replyService.createReply(content, postId, principal.getName());
		
		return String.format("redirect:/post/detail?id=%d#reply_%d", postId, reply.getId());
	}
	
	@GetMapping("/delete/{replyId}")
	public String delete(@PathVariable("replyId") Long replyId, Principal principal) {
		Reply reply = replyService.getReply(replyId);
		if (!reply.getUser().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "다른 작성자의 댓글 삭제할 수 없습니다.");
		}
		replyService.deleteReply(reply);
		
		return String.format("redirect:/post/detail?id=%d", reply.getPost().getId());
	}
	
	@GetMapping("/vote/{replyId}")
	public String vote(@PathVariable("replyId") Long replyId, Principal principal) {
		Reply reply = replyService.getReply(replyId);
		replyService.vote(replyId, principal.getName());
		
		return String.format("redirect:/post/detail?id=%d#reply_%d", reply.getPost().getId(), reply.getId());
	}
	
	@PostMapping("/modify/{replyId}")
	public String modify(@PathVariable("replyId") Long replyId,
			@RequestParam("content") String content, Principal principal,
			RedirectAttributes redirectAttributes) {
		
		Reply reply = replyService.getReply(replyId);
		if (!reply.getUser().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "다른 작성자의 댓글 삭제할 수 없습니다.");
		}
		
		replyService.modify(reply, content);
		redirectAttributes.addFlashAttribute("replyId", replyId);
		
		return String.format("redirect:/post/detail?id=%d#reply_%d", reply.getPost().getId(), reply.getId());
	}
}
