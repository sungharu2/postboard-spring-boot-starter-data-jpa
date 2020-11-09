package com.example.application.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.application.dto.BoardDto;
import com.example.application.entity.BoardEntity;
import com.example.application.repository.BoardRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardService {
	private BoardRepository boardRepository;
	
	@Transactional
	public Long savePost(BoardDto boardDto) {
		return boardRepository.save(boardDto.toEntity()).getId();
	}

	public List<BoardDto> getBoardList() {
		List<BoardEntity> boardEntities = boardRepository.findAll();
		List<BoardDto> boardDtoList = new ArrayList<>();
		
		for (BoardEntity boardEntity : boardEntities) {
			BoardDto boardDto = BoardDto.builder()
					.id(boardEntity.getId())
					.title(boardEntity.getTitle())
					.writer(boardEntity.getWriter())
					.content(boardEntity.getContent())
					.createdDate(boardEntity.getCreatedDate())
					.build();
			
			boardDtoList.add(boardDto);
		}
		
		return boardDtoList;
	}
}
