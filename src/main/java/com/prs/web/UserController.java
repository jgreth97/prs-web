package com.prs.web;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.prs.business.User;
import com.prs.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
	public class UserController {	
		@Autowired
		private UserRepo userRepo;
		
//get user by username and password
	@GetMapping("/{username}/{password}")
		public User getUsernameAndPassword(@PathVariable String username, String password) {
			return userRepo.findByUserNameAndPassword(username, password);
				}
	
// list all Users
	@GetMapping("/")
		public List<User> getallUsers(@PathVariable int id) {
			return userRepo.findAll();
			}
	
// get User by id
	@GetMapping("/{id}")
		public Optional<User> getUser(@PathVariable int id) {
			Optional<User> uu = userRepo.findById(id);
				if (uu.isPresent()) {
					return uu;
						}
				else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
						}
				}
// add all Users
	@PostMapping("/")
		public User addUser(@RequestBody User uu) { //in the incoming request there is a body(User)
			return userRepo.save(uu);
				}
	
//update a User(put)
	@PutMapping("/")
		public User updateUser(@RequestBody User uu,@PathVariable int id) { //in the incoming request there is a body(User)
			return userRepo.save(uu);
				}
	
//delete a User
	@DeleteMapping("/{id}")
		public Optional<User> deleteUser(@PathVariable int id) { //in the incoming request there is a body(User)
			Optional<User> uu = userRepo.findById(id); 
				if (uu.isPresent()) {
					userRepo.deleteById(id);;
					}
				else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");	
					}
				return uu;
				
	}
	}
