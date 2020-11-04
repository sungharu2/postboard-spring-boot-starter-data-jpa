package com.example.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entity.Comment;
import com.example.application.entity.Post;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findCommentsByPost(Post post);
	
}
