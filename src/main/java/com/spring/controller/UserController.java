package com.spring.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.bean.Role;
import com.spring.bean.User;
import com.spring.bean.User;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import com.spring.service.UserService;

@RestController
@RequestMapping(value={"/user"})
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;
	
//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
//        System.out.println("Fetching User with id " + id);
//        User user = userService.findById(id);
//        if (user == null) {
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }
    
	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<String> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getUsername());

		HttpHeaders headers = new HttpHeaders();
		if (!user.getPassword().equals(user.getPasswordConfirm())) {
			return new ResponseEntity<String>("Password and PasswordConfirmed does'not match.", headers,
					HttpStatus.UNPROCESSABLE_ENTITY);
		}

		Role role = roleService.findById(1);
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);

		userService.createUser(user);

		return new ResponseEntity<String>("Sucssessfully created.", headers, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/login", headers = "Accept=application/json")
	public ResponseEntity<User> loginUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Try Login User " + user.getUsername());

		HttpHeaders headers = new HttpHeaders();
		
		User foundUser = userService.findByMobileNumberAndPassword(user.getMobileNumber(),user.getPassword());
		if(null !=foundUser ){
			return new ResponseEntity<User>(foundUser, headers, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<User>(foundUser, headers, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
	}

//	 @GetMapping(value="/get", headers="Accept=application/json")
//	 public List<User> getAllUser() {	 
//	  List<User> tasks=userService.getUser();
//	  return tasks;
//	
//	 }
//
//	@PutMapping(value="/update", headers="Accept=application/json")
//	public ResponseEntity<String> updateUser(@RequestBody User currentUser)
//	{
//		System.out.println("sd");
//	User user = userService.findById(currentUser.getId());
//	if (user==null) {
//		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
//	}
//	userService.update(currentUser, currentUser.getId());
//	return new ResponseEntity<String>(HttpStatus.OK);
//	}
//	
//	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
//	public ResponseEntity<User> deleteUser(@PathVariable("id") long id){
//		User user = userService.findById(id);
//		if (user == null) {
//			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//		}
//		userService.deleteUserById(id);
//		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//	}
//	
//	@PatchMapping(value="/{id}", headers="Accept=application/json")
//	public ResponseEntity<User> updateUserPartially(@PathVariable("id") long id, @RequestBody User currentUser){
//		User user = userService.findById(id);
//		if(user ==null){
//			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//		}
//		User usr =	userService.updatePartially(currentUser, id);
//		return new ResponseEntity<User>(usr, HttpStatus.OK);
//	}
}
