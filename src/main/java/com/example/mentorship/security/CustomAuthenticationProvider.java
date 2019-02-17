package com.example.mentorship.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.mentorship.model.User;
import com.example.mentorship.model.UserDetail;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private JdbcTemplate template;

	@Override
	public Authentication authenticate(Authentication authentication) {
		String userName = authentication.getName();
		String password = authentication.getCredentials() != null ? authentication.getCredentials().toString() : null;
		try {
			String query = "SELECT * FROM users Where username = ?";
			User user = template.queryForObject(query, new BeanPropertyRowMapper<User>(User.class), userName);
			if (user != null && user.getPassword().equals(password)) {
				UserDetails myUserDetail = new UserDetail(user);
				return new UsernamePasswordAuthenticationToken(myUserDetail.getUsername(), myUserDetail.getPassword(),
						myUserDetail.getAuthorities());
			} else {
				return null;
			}
		} catch (DataAccessException exception) {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
