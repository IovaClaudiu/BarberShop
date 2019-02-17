package com.example.mentorship.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.mentorship.model.User;
import com.example.mentorship.security.CustomAuthenticationProvider;

@RestController
@RequestMapping("/")
public class MainController {

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private CustomAuthenticationProvider authProvider;

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("home");
		return view;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView view = new ModelAndView();
		view.addObject("user", new User());
		view.setViewName("login");
		return view;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.authenticate(response);
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public String registerUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (doesUserExists(user.getUsername())) {
			return "The user already exists!";
		} else {
			if (registerUser(user)) {
				return redirectAfterLogIn(user);
			}
		}
		return "Failed to registed user!";
	}

	private String redirectAfterLogIn(User user) {
		try {
			Authentication authenticate = authProvider
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			return "home";
		} catch (AuthenticationException e) {
			return "error";
		}
	}

	private boolean doesUserExists(String username) {
		String query = "SELECT * FROM users WHERE username = ?";
		try {
			return template.queryForObject(query, new BeanPropertyRowMapper<User>(User.class), username) != null;
		} catch (DataAccessException e) {
			return false;
		}
	}

	private boolean registerUser(User user) {
		String query = "INSERT INTO users (username,password,role) VALUES (? , ? , ?)";
		int update = template.update(query, user.getUsername(), user.getPassword(), "USER");
		return update > 0;
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			session = null;
		}
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:login");
		return view;
	}
}