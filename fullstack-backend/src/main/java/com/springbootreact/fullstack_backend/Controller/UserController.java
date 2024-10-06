package com.springbootreact.fullstack_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootreact.fullstack_backend.Exceptions.UserNotFoundException;
import com.springbootreact.fullstack_backend.Model.User;
import com.springbootreact.fullstack_backend.Repository.UserRepository;


@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/User")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@GetMapping("/Users")
	List<User> getAllUsers(){
		return userRepository.findAll();
		}
	
	
	@GetMapping("/User/{id}")
	User getUserById(@PathVariable Long id) {
		return userRepository.findById(id)
				.orElseThrow(()-> new UserNotFoundException(id));
		}
	
	@PutMapping("/User/{id}")
	User updateUser(@RequestBody User newUser , @PathVariable Long id) {
		return userRepository.findById(id)
				.map(user ->{
					user.setUseName(newUser.getUseName());
					user.setName(newUser.getName());
					user.setEmail(newUser.getEmail());
					return userRepository.save(user);
				}).orElseThrow(()-> new UserNotFoundException(id));
	}
	
	@DeleteMapping("/User/{id}")
	String deleteUser(@PathVariable Long id) {
		if(!userRepository.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		userRepository.deleteById(id);
		return "user with id "+id+" has been deleted successfully ";
	}
}
