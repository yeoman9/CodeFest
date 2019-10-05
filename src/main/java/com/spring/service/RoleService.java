package com.spring.service;

import java.util.List;

import com.spring.bean.Role;

public interface RoleService {
	public void createRole(Role role);
	public List<Role> getRole();
	public Role findById(long id);
	public Role update(Role role, long id);
	public void deleteRoleById(long id);
	public Role updatePartially(Role role, long id);
}
