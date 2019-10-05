package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.bean.Role;

@Repository
public class RoleDaoImpl implements RoleDao{
	@Autowired
	private SessionFactory sessionFactory;
	  
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		  session.save(role); 
	}

	public List<Role> getRole() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Role> list= session.createCriteria(Role.class).list();
		return list;
	}

	public Role findById(long id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		Role role=(Role) session.get(Role.class,id);
		return role;
	}

	public Role update(Role val, long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Role role =(Role)session.get(Role.class, id);
		/*add necessary collumns */
		
		session.update(role);
		return role;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Role role = findById(id);
		session.delete(role);
	}
	@Override
	public Role updateCountry(Role val, long id){
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role)session.load(Role.class, id);
		//role.setCountry(val.getCountry());
		return role;
	}

	

}
