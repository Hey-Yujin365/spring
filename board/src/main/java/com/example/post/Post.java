package com.example.post;

import java.util.List;
import java.util.Set;

import com.example.common.BaseDateTimeEntity;
import com.example.reply.Reply;
import com.example.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 * @ManyToOne
 * 		- N:1(다대일) 연관관계를 표현하는 어노테이션이다.
 * 		- @ManyToOne 어노테이션이 붙어있는 엔티티가 N이고, 반대 엔티티가 1이다.
 * 		  즉, Post 엔티티가 N이고, User 엔티티가 1이다.
 * 		- 가장 많이 사용되는 연관관계 표현 어노테이션이다.
 */

@Entity
@Table(name = "board_posts")
@SequenceGenerator(
	name = "post_pk_generator",
	sequenceName = "board_posts_seq",
	initialValue = 1000,
	allocationSize = 1
)
@Getter
@Setter
public class Post extends BaseDateTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_pk_generator")
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	/*
	 * Entity에 @ManyToOne은
	 *  - 다대일 관계를 표현하는 어노테이션이다.
	 *  - 게시글과 사용자는 다대일 관계다.
	 *  - 사용자는 게시글을 여러 개 작성할 수 있다. 사용자 → 게시글(1:N)
	 *  - 이 게시글의 작성자는 한 사용자다.        게시글 → 사용자(1:1)
	 *  
	 *  추가로 @JoinColumn(name = "N쪽 테이블의 외래키컬럼명")
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(nullable = false)
	private String content;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<Reply> replies;	// 댓글은 순서가 중요해서 List
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)	// cascade를 붙여주면 post가 삭제될 때 voter도 삭제된다.
	private Set<PostVoter> postVoters;	// 추천은 중복으로 할 수 없게 Set(상황에 따라 List로 해도 되긴 하다.)
}
