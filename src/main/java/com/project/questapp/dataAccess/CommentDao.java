package com.project.questapp.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.Comment;

public interface CommentDao extends JpaRepository<Comment, Long>{

}
