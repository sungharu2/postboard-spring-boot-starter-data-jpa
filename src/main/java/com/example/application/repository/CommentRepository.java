package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entity.Post;

public interface CommentRepository extends JpaRepository<Post, Long>{

}
