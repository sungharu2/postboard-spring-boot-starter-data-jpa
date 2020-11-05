package com.example.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.application.entity.Post;
import com.example.application.repository.PostRepository;

@RestController
public class PostController {
	@Autowired
	PostRepository postRepository;
	
	
	@GetMapping("/post")
	public List<Post> getAllPost() {
		return postRepository.findAll();
	}
	
	@GetMapping("/post/{id}")
	public Post getPost(@PathVariable String id) {
		Long postId = Long.parseLong(id);
		
		Optional<Post> post = postRepository.findById(postId);
		
		return post.get();
	}
	
	@PostMapping("/post/{id}")
	public Post updatePost(@PathVariable String id, @RequestBody Post newPost) {
		Long postId = Long.parseLong(id);
		
		Optional<Post> post = postRepository.findById(postId);
		
		post.get().setTitle(newPost.getTitle());
		post.get().setContent(newPost.getContent());
		
		postRepository.save(post.get());
		
		return post.get();
	}
	
	@PostMapping("/post")
	public Post createPost(Post post) {		// html에서 json form으로 데이터를 주지 않음, @RequestBody 어노테이션 사용 안 해야 인식
		Post newPost = postRepository.save(post);
		
		return newPost;
	}
	
	@DeleteMapping("/post/{id}")
	public String deletePost(@PathVariable String id) {
		Long postId = Long.parseLong(id);
		postRepository.deleteById(postId);
		
		return "Delete Success";
	}
}
