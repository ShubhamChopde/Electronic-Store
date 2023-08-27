package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.User;
import com.wipro.repo.UserRepository;
/**
 * This is a user entity related service
* @author xxxxxx xxxxxxx(@github - xxxxxxxxxxx)
* @since 0.0.1
**/
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private EmailService emailservice;
	
	//for saving the user object in the database
	@Override
	public int save(User u) {
		repo.save(u);
		String msg = "Hi "+u.getUsername()+" ! \n Welcome to our website Electronic Store. " 
				+ "\nHere you can find products that you desire at th prices that you cannot resist"
				+ "\nHAPPY SHOPPING !!";
		String sub= "Welcome to Electronic Store. ";
		emailservice.sendEmail(u.getEmail(),sub,msg);
		return u.getUserId();
	}
	//for updating the user object in the database

	@Override
	public boolean update(User u) {
		repo.save(u);
		return true;
	}
	//for fetching the user object by userId from the database
	@Override
	public User fetch(int userId) {
		return repo.findById(userId).get();
	}  
	 //for listing all users that are saved in the database 
	@Override
	public List<User> list() {
		return repo.findAll();
	}

	//validate method used for login. Checks if email and password is correct
	@Override
	public User validate(String email, String password) {
		return repo.validate(email, password);
	}
	//for fetching the user object by email from the database
	@Override
	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}
}
