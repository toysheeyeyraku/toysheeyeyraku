package org.toysheeyeyraku.controllers;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.toysheeyeyraku.models.Role;
import org.toysheeyeyraku.models.User;
import org.toysheeyeyraku.repositories.UserRepository;
import org.toysheeyeyraku.services.DynamicLoginService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private UserRepository repository;

	@GetMapping("/form")
	public String getRegisterForm() {
		return "register";
	}
	@Autowired
	private PasswordEncoder encoder;
	@PostMapping("/registerme")
	public String e(@RequestParam("password") String password, @RequestParam("username") String username,
			HttpServletRequest request) throws Exception {
		if (repository.findByUsername(username) == null) {
			User us = User.createDefaultUser(username, password, encoder);
			repository.save(us);
			loginService.authenticateUserAndSetSession(us.getUsername(), request,password);
			return "redirect:../creation";
		}
		
		
		return "register";
	}

	@Autowired
	private DynamicLoginService loginService;
}
