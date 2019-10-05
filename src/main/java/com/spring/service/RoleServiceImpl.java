package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bean.Role;
import com.spring.dao.RoleDao;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDao roleDao;


	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return roleDao.getRole();
	}

	public Role findById(long id) {
		// TODO Auto-generated method stub
		return roleDao.findById(id);
	}

	public void createRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.addRole(role);
	}

	public void deleteRoleById(long id) {
		// TODO Auto-generated method stub
		roleDao.delete(id);
	}
	@Override
	public Role updatePartially(Role role, long id) {
		roleDao.updateCountry(role,id);
		return roleDao.findById(id);
	}

	@Override
	public Role update(Role role,long id) {
		// TODO Auto-generated method stub
		return roleDao.update(role, id);
	}

	
	

	

}
