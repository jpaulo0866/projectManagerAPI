package com.viaflow.manager.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.viaflow.manager.api.entity.user.Profile;
import com.viaflow.manager.api.entity.user.User;



public class JwtUserFactory {

	public JwtUserFactory() {
				
	}
	
	public static JwtUser create(User user) {
		return new JwtUser(user.getUserId(), user.getLogin(), user.getPassword(), 
					mapToGrantedAuthorities(user.getProfile()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(Profile profile) {
		List<GrantedAuthority> authorites = new ArrayList<>();
		authorites.add(new SimpleGrantedAuthority(profile.getProfileName()));
		return authorites;
	}
	
	
}
