package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{

}
