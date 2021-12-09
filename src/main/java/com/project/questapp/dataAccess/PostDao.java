package com.project.questapp.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.Post;

public interface PostDao extends JpaRepository<Post, Long> {
	List<Post> findByUserId(Long userId);
}
