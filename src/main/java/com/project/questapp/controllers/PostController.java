package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.business.concretes.PostService;
import com.project.questapp.entities.Post;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	private PostService postService;

	@Autowired
	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	@GetMapping
	public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
		return postService.getAllPosts(userId);
		
	}
	@PostMapping
	public Post createOnePosts(@RequestBody Post newPost) {
		return postService.createOnePosts(newPost);
		
	}
	@GetMapping("/{postId}")
	public Post getOnePosts(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
	

}
