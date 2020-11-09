package com.example.application.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.application.dto.BoardDto;
import com.example.application.service.BoardService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class BoardController {
	private BoardService boardService;
	
	// TODO
	// 게시글 리스트 조회
	@GetMapping("/")
	public String list(Model model) {
		List<BoardDto> postList = boardService.getBoardList();
		
		model.addAttribute("postList", postList);
		return "board/list.html";
	}

	// TODO
	// 단일 게시글 조회
	@GetMapping("/post/{id}")
	public void getPost(@PathVariable String id) {
		Long boardId = Long.parseLong(id);
		
		//Optional<PostEntity> post = postService.findById(postId);
		
	}
	
	// 게시글 생성
	@PostMapping("/post")
	public String createPost(BoardDto boardDto) {		// html에서 json form으로 데이터를 주지 않음, @RequestBody 어노테이션 사용 안 해야 인식
		boardService.savePost(boardDto);
		
		return "redirect:/";
	}
	
	// 게시글 삭제 (기능 미사용/보류)
	/*
	@DeleteMapping("/post/{id}")
	public String deletePost(@PathVariable String id) {
		Long postId = Long.parseLong(id);
		postRepository.deleteById(postId);
		
		return "Delete Success";
	} */

	// 게시글 수정 (기능 미사용/보류)
	/*
	@PostMapping("/post/{id}")
	public PostEntity updatePost(@PathVariable String id, @RequestBody PostEntity newPost) {
		Long postId = Long.parseLong(id);
		
		Optional<PostEntity> post = postRepository.findById(postId);
		
		post.get().setTitle(newPost.getTitle());
		post.get().setContent(newPost.getContent());
		
		postRepository.save(post.get());
		
		return post.get();
	} */
	
}
