package com.example.application.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id @GeneratedValue
	@Column(name = "comment_id")
	private Long id;
	
	private String title;
	private String content;
	
	private String writer;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public Post getPost() {
		return post;
	}
	
	public void setPost(Post post) {
		this.post = post;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Comment comment = (Comment) o;
		return Objects.equals(id, comment.id) &&
				Objects.equals(title, comment.title) &&
				Objects.equals(content, comment.content) &&
				Objects.equals(writer, comment.writer);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, title, content, writer);
	}
}
