package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
