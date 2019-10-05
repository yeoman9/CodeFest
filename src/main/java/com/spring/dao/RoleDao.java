package com.spring.dao;

import java.util.List;

import com.spring.bean.Role;

public interface RoleDao {
	public void addRole(Role role);
	public List<Role> getRole();
	public Role findById(long id);
	public Role update(Role role, long id);
	public Role updateCountry(Role role, long id);
	public void delete(long id);
	
}
