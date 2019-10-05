package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bean.User;
import com.spring.dao.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;


	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userDao.getUser();
	}

	public User findById(long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	public void createUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}
	@Override
	public User updatePartially(User user, long id) {
		userDao.updateCountry(user,id);
		return userDao.findById(id);
	}

	@Override
	public User update(User user,long id) {
		// TODO Auto-generated method stub
		return userDao.update(user, id);
	}

	
	

	

}
