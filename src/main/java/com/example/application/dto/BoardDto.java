package com.example.application.dto;

import java.time.LocalDateTime;

import com.example.application.entity.BoardEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
	private Long id;
	private String title;
	private String writer;
	private String content;
	private LocalDateTime createdDate;
	
	
	public BoardEntity toEntity() {
		BoardEntity postEntity = BoardEntity.builder()
				.id(id)
				.title(title)
				.writer(writer)
				.content(content)
				.build();
		return postEntity;
	}
	
	@Builder
	public BoardDto(Long id, String title, String writer, String content, LocalDateTime createdDate) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createdDate = createdDate;
	}
}
