package com.project.questapp.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.questapp.dataAccess.PostDao;
import com.project.questapp.entities.Post;

@Service

public class PostService {
	private PostDao postDao;

	@Autowired
	public PostService(PostDao postDao) {
		super();
		this.postDao = postDao;
	}

	public List<Post> getAllPosts(Optional<Long> userId) {  // burada yaptıgımız iş şu :bız hem postId i yi hemde postsların hepsini böyle tek bir şeyde yazabılırız 
		if(userId.isPresent())  
			return postDao.findByUserId(userId.get());
		return postDao.findAll();
	}

	public Post getOnePostById(Long postId) {
		return postDao.findById(postId).orElse(null);
		
	}

	public Post createOnePosts(Post newPost) {
		return postDao.save(newPost);
	}
	
	
	
	
	

}
