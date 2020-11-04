package com.example.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.application.entity.Comment;
import com.example.application.entity.Post;
import com.example.application.repository.CommentRepository;
import com.example.application.repository.PostRepository;

@RestController
public class CommentController {
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/post/{id}/comment")
	public List<Comment> getPostComments(@PathVariable Long id) {
		Post post = postRepository.findById(id).get();
		return commentRepository.findCommentsByPost(post);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/post/{id}/comment")
	public Comment createComment(@PathVariable Long id, @RequestBody Comment comment) {
		Optional<Post> postItem = postRepository.findById(id);
		comment.setPost(postItem.get());
		commentRepository.save(comment);
		return comment;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/post/{id}/comment/{commentID}")
	public Comment updateComment(@PathVariable Long id, @PathVariable Long commentID, @RequestBody Comment comment) {
		Optional<Post> postItem = postRepository.findById(id);
		comment.setPost(postItem.get());
		Comment newComment = commentRepository.findById(commentID).get();
		newComment.setTitle(comment.getTitle());
		newComment.setContent(comment.getContent());
		newComment.setWriter(comment.getWriter());
		commentRepository.save(newComment);
		return newComment;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/post/{id}/comment/{commentID}")
	public String deleteComment(@PathVariable Long id, @PathVariable Long commentID) {
		commentRepository.deleteById(commentID);
		return "Comment Delete Success";
	}
	
}
