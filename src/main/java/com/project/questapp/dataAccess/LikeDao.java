package com.project.questapp.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.Like;

public interface LikeDao extends JpaRepository<Like, Long> {

}
