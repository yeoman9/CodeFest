package com.spring.dao;

import java.util.List;

import com.spring.bean.User;

public interface UserDao {
	public void addUser(User user);
	public List<User> getUser();
	public User findById(long id);
	public User update(User user, long id);
	public User updateCountry(User user, long id);
	public void delete(long id);
	public User findByMobileNumberAndPassword(String mobileNumber,String password);
	
}
