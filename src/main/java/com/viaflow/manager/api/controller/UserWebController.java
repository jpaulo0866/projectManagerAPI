package com.viaflow.manager.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.viaflow.manager.api.entity.user.Team;
import com.viaflow.manager.api.entity.user.User;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.TeamService;
import com.viaflow.manager.api.service.UserService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserWebController extends BaseController<User, UserService, BaseValidation<User>> {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private BaseValidation<User> baseValidation;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected UserService getService() {
		return this.userService;
	}

	@Override
	protected BaseValidation<User> getValidation() {
		return this.baseValidation;
	}
	
	@Override
	@PostMapping
	public ResponseEntity<Response<User>> create(HttpServletRequest req, @RequestBody User object, 
			BindingResult result) { 
		Response<User> response = new Response<>();
		try {
			if (baseValidation != null) {
				if (!baseValidation.validateObject(object, result)) {
					result.getAllErrors().forEach(error -> {
						response.getErrors().add(error.getDefaultMessage());
					});
					return ResponseEntity.badRequest().body(response);
				}
			}
			object.setPassword(passwordEncoder.encode(object.getPassword()));
			User persistedObject = userService.createOrUpdate(object);
			response.setData(persistedObject);
			
		} catch (Exception e) {
			response.getErrors().add("Critical Error on Request! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}		
		
		return ResponseEntity.ok(response);
	}
	
	@Override
	@PutMapping
	public ResponseEntity<Response<User>> update(HttpServletRequest req, @RequestBody User object, 
			BindingResult result) { 
		Response<User> response = new Response<>();
		
		try {
			if (baseValidation != null) {
				if (!baseValidation.validateObject(object, result)) {
					result.getAllErrors().forEach(error -> {
						response.getErrors().add(error.getDefaultMessage());
					});
					return ResponseEntity.badRequest().body(response);
				}
			}
			User oldUser = this.userService.findById(object.getUserId());
			if (object.getPassword() == null
					|| object.getPassword().isEmpty()
					|| object.getPassword().equals(oldUser.getPassword())) {
				object.setPassword(oldUser.getPassword());
			} else {
				object.setPassword(passwordEncoder.encode(object.getPassword()));
			}
			User persistedObject = userService.createOrUpdate(object);
			response.setData(persistedObject);
			
		} catch (Exception e) {
			response.getErrors().add("Critical Error! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/teams/{userId}/{page}/{count}")
	public ResponseEntity<Response<Page<Team>>> getTeamByUser(
			@PathVariable("userId") String userId,
			@PathVariable("page") int page,
			@PathVariable("count") int count){
		Response<Page<Team>> response = new Response<>();
		Page<Team> list = teamService.findByUser(userId, page, count);
		response.setData(list);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/find/profile/{profileId}/{page}/{count}")
	public ResponseEntity<Response<Page<User>>> getUserByProfile(
			@PathVariable("profileId") String profileId,
			@PathVariable("page") int page,
			@PathVariable("count") int count){
		Response<Page<User>> response = new Response<>();
		Page<User> list = userService.findByProfileId(profileId, page, count);
		response.setData(list);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/ad/{vinculated}/{page}/{count}")
	public ResponseEntity<Response<Page<User>>> getUserByLdapUser(
			@PathVariable("vinculated") boolean ldapUser,
			@PathVariable("page") int page,
			@PathVariable("count") int count){
		Response<Page<User>> response = new Response<>();
		Page<User> list = userService.findByLdapUser(ldapUser, page, count);
		response.setData(list);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/find/login/{login}")
	public ResponseEntity<Response<User>> getUserByLogin(@PathVariable("login") String login){
		Response<User> response = new Response<>();
		User user = getService().findByLogin(login);
		if (user == null) {
			response.getErrors().add("Register not found " + login);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(user);
		return ResponseEntity.ok(response);
	}
}
