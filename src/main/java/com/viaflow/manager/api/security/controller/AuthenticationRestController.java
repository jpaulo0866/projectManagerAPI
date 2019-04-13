package com.viaflow.manager.api.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.user.User;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.security.jwt.JwtAuthenticationRequest;
import com.viaflow.manager.api.security.jwt.JwtTokenUtil;
import com.viaflow.manager.api.security.ldap.LdapAuth;
import com.viaflow.manager.api.security.model.CurrentUser;
import com.viaflow.manager.api.service.UserService;
import com.viaflow.manager.global.Constants;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationRestController  {
	
	@Autowired
	@Lazy
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private LdapAuth ldapAuth;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/api/auth/user/image/{login}")
	public ResponseEntity<?> createAuthenticationToken(@PathVariable("login") String login) throws Exception {
		final User user = userService.findByLogin(login);
		Response<String> resp = new Response<String>();
		if (user != null) {
			resp.setData(user.getImage());
		}
		return ResponseEntity.ok(resp);
	}
	
	@PostMapping(value="/api/auth")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
		final User user = userService.findByLogin(authenticationRequest.getLogin());
		if (user == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ObjectError("User", "User not found"));
		}
		
		if (user.isDisabled()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ObjectError("User", "User is disabled!\nContact your administrator"));
		}
		
		if (user.isLdapUser()) {
			try {
				if (!ldapAuth.authenticate(authenticationRequest)) {
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ObjectError("LdapAuth", "Username or password invalid"));
				}
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ObjectError("LdapAuth", e.toString()));
			}
			
			
		} else {
			final Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(), authenticationRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getLogin());
		final String token = jwtTokenUtil.generateToken(userDetails);

		if (user != null) {
			user.setPassword(null);
		}
		return ResponseEntity.ok(new CurrentUser(token, user));
	}
	
	@PostMapping(value="/api/refresh")
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) throws Exception {
		String token = request.getHeader(Constants.TOKEN_LOCATION);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		final User user = userService.findByLogin(username);
		
		if (jwtTokenUtil.canTokenBeRefreshed(token)) {
			String refreshedToken = jwtTokenUtil.refreshToken(token);
			return ResponseEntity.ok(new CurrentUser(refreshedToken, user));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
}
