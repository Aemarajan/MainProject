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
	
	public void createUser(String role,String name,String email,String username,String password,int privilege_provide,boolean i) {
		User u = new User(role,name,email,username,password,privilege_provide,i ? 1 : 0);
		userRepo.save(u);
	}

	public void updateUser(int id, String role, String name, String email, String username, String password, int privilege_provide, boolean inn) {
		userRepo.updateUser(id,role,name,email,username,password,privilege_provide,inn ? 1 : 0);	
	}
	
	public List<User> selectByPp(int i) {
		List<User> list = userRepo.selectByPP(i);
		return list;
	}
	
	public List<User> selectAllUser(){
		return userRepo.findAll();
	}
	
	public List<User> selectAllAdministrators(){
		return userRepo.findAllAdministrators();
	}
	
	public List<User> selectAllStaffs(){
		return userRepo.findAllStaffs();
	}
	
	public List<User> selectAllStudents(){
		return userRepo.findAllStudents();
	}
	
	public List<User> selectAllExceptId(int id) {
		return userRepo.findAllById(id);
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
				user.setPrivilege_provide(u.getPrivilege_provide());
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

	public void updateInnZero(int id, int i) {
		userRepo.updateInnZero(id,i);
	}
}
