package com.example.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "post")
public class PostEntity extends TimeEntity {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "post_id")
	private Long id;

	@Column(length = 100, nullable = false)
	private String title;
	
	@Column(length = 10, nullable = false)
	private String writer;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	@Builder
	public PostEntity(Long id, String title, String writer, String content) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
}
