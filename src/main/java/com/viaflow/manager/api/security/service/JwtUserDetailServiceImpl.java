package com.viaflow.manager.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.user.User;
import com.viaflow.manager.api.security.jwt.JwtUserFactory;
import com.viaflow.manager.api.service.UserService;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userService.findByLogin(login);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Nenhum usuário encontrado com o login %s", login));
		} else {
			return JwtUserFactory.create(user);
		}
	}

}
