package com.example.application.dto;

import java.time.LocalDateTime;

import com.example.application.entity.PostEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDto {
	private Long id;
	private String title;
	private String writer;
	private String content;
	private LocalDateTime createdDate;
	
	
	public PostEntity toEntity() {
		PostEntity postEntity = PostEntity.builder()
				.id(id)
				.title(title)
				.writer(writer)
				.content(content)
				.build();
		return postEntity;
	}
	
	@Builder
	public PostDto(Long id, String title, String writer, String content, LocalDateTime createdDate) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createdDate = createdDate;
	}
}
