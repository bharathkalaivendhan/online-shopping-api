package com.bk.OnlineShoppingAPI.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	ResponseEntity<User> addUser(@RequestBody User user)
	{
		userService.addUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);		
	}
	
	@PostMapping("/add-all")
	ResponseEntity<List<User>> addAllUser(@RequestBody List<User> users)
	{
		userService.addAllUser(users);
		return new ResponseEntity<List<User>>(HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all")
	ResponseEntity<List<User>> getAllUser() throws UserNotFoundException
	{
		return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.FOUND);	
	}
	
	@GetMapping("/get-by-id/{id}")
	ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws UserNotFoundException
	{
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update-user/{id}")
	ResponseEntity<User> updateUserDetails(@PathVariable("id") Long id, @RequestBody User user) throws UserNotFoundException
	{	
		userService.updateUserDetails(id, user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-by-id/{id}")
	ResponseEntity<User> removeUserById(@PathVariable("id") Long id)
	{
		userService.removeUserById(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-all")
	ResponseEntity<User> removeAllUser()
	{
		userService.removeAllUser();
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
}

