package com.sarat.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.sarat.entity.User;
import com.sarat.service.UserService;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		//String password = authentication.getCredentials().toString();
		User user = null;
		try {
			user = userService.loadByUsername(username);
		} catch (Exception e) {
			throw new BadCredentialsException(e.getMessage());
		}
		if(user == null){
			throw new BadCredentialsException("User is not registered with us. Please register first.");
		}
		
		if(!encoder.matches(authentication.getCredentials().toString(), user.getPassword())){
			throw new BadCredentialsException("Username or Password not matched.");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		authorities.add(authority);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, user.getPassword(), authorities);
		//authentication.setAuthenticated(true);
		return authenticationToken;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
	}

}
