package com.example.application.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.application.dto.PostDto;
import com.example.application.repository.PostRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostService {
	private PostRepository postRepository;
	
	@Transactional
	public Long savePost(PostDto postDto) {
		return postRepository.save(postDto.toEntity()).getId();
	}
}
