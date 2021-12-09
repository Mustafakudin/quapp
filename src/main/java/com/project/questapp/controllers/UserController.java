package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.business.concretes.UserService;
import com.project.questapp.dataAccess.UserDao;
import com.project.questapp.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {
	// userıd 2 tanesi ile karşilaşıyor hatayı bul 
	private UserService userService;
	@Autowired
	private UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping // getirmek anlamında butun kullanıcıları getirmek için kullanıyoruz
	public List<User> getAll(){
		return userService.findAll();
		
	}
	@PostMapping // bir şeyleri oluşturmak için postmapping dedik 
							// requstbody su gelen istekleri requesten alıp bir user objesıne maple ve buna o user objesını dön
	public User createUser(@RequestBody User newUser) {  
		return userService.saveOneUser(newUser);
	}
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		return userService.getOneUser(userId); 
	}
	

	

	// var olan id li değiştirebiliriz anlamında
	@PutMapping("/{userId}") // postmapping yapmadık cunku biizm databaseımıze biri id vererek kaydolamısnı istemeyiz  put yaparız yani varolan bir idli bir user i değiştirebiliriz
	public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser) {
		return userService.updateOneUser(userId,newUser);
	
	}
	@DeleteMapping("/{userId}") // birisi bize delete isteği attıgında yine bir spesifik user için mapping yapıyoruz body i gerek yok cunku ıd sini aldıgı kişi silsin ondan yazmıyoruz 
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId);
	}
	
	
	
	

}
