package com.viaflow.manager.api.session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viaflow.manager.api.entity.user.User;
import com.viaflow.manager.api.security.jwt.JwtTokenUtil;
import com.viaflow.manager.api.service.UserService;
import com.viaflow.manager.global.Constants;

@Component
public class SessionUtils {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userService;
	
	public User userFromRequest(HttpServletRequest req) {
		String token = req.getHeader(Constants.TOKEN_LOCATION);
		String login = jwtTokenUtil.getUsernameFromToken(token);
		return userService.findByLogin(login);
	}
}
