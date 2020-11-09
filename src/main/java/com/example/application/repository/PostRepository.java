package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long>{

}
