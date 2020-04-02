package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.User;
import com.project.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public void createUser(User user) {
		userRepo.save(user);
	}

	public List<User> selectByPp(int i) {
		List<User> list = userRepo.selectByPP(i);
		return list;
	}
	
	public List<User> selectAllUser(){
		return userRepo.findAll();
	}
	
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public User findByPassword(String password) {
		return userRepo.findByPassword(password);
	}
	
	public User findById(int id) {
		List<User> list = userRepo.findById(id);
		User user = new User();
		for(User u:list) {
			if(u.getUser_id() == id) {
				user.setUser_id(u.getUser_id());
				user.setName(u.getName());
				user.setUsername(u.getUsername());
				user.setPassword(u.getPassword());			
				user.setPrivilegeProvide(u.getPrivilegeProvide());
			}
		}
		return user;
	}

	public void updatePrivilegeProvide(int id, int i) {
		userRepo.updatePrivilegeProvide(id,i);
	}

	public void updatePassword(String password, int i) {
		userRepo.updatePassword(password,i);
	}
}
