package com.project.questapp.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.questapp.dataAccess.UserDao;
import com.project.questapp.entities.User;

@Service
public class UserService {
	
	private  UserDao userDao;  //  autowired repodan save findall ıd vs cekiyoruz 

	 @Autowired
	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User saveOneUser(User newUser) {
		return userDao.save(newUser);
	}

	public User getOneUser(Long userId) {
		return userDao.findById(userId).orElse(null); // yani  eğer bulamazsan bu user ı null dön 
	}

	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user=userDao.findById(userId);
		if(user.isPresent()) {  // optional kullanıdıgımz ıcın is present dedik anlamı su obje var demek
		User foundUser=user.get();  // BURADA kullaıcıyı değiştirmek istersek ilk once kullanıcı foundusera atıyıp ondan sonra newUserla getirdik gibi düşün
		foundUser.setUserName(newUser.getUserName()); // BÖYLE YAPARAK YENİ USERNAME UPDATE YAPMIS OLUYORUZ 
		foundUser.setPassword(newUser.getPassword());
		userDao.save(foundUser);
		return foundUser; // direkt return userDao.save(foundUser); diyedebiliriz
	}
	else {
		return null ;
	}
	}

	public void deleteById(Long userId) {
		userDao.deleteById(userId);
	}
	
	
	

}
