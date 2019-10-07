package com.spring.service;

import java.util.List;

import com.spring.bean.User;

public interface UserService {
	public void createUser(User user);
	public List<User> getUser();
	public User findById(long id);
	public User update(User user, long id);
	public void deleteUserById(long id);
	public User updatePartially(User user, long id);
	public User findByMobileNumberAndPassword(String mobileNumber,String password);
}
