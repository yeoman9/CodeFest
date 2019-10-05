package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.bean.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	  
	public void addUser(User user) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		  session.save(user); 
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> list= session.createCriteria(User.class).list();
		return list;
	}

	public User findById(long id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		User user=(User) session.get(User.class,id);
		return user;
	}

	public User update(User val, long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User user =(User)session.get(User.class, id);
		/*add necessary collumns */
		
		session.update(user);
		return user;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User user = findById(id);
		session.delete(user);
	}
	@Override
	public User updateCountry(User val, long id){
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.load(User.class, id);
		//user.setCountry(val.getCountry());
		return user;
	}

	

}
