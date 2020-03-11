package org.toysheeyeyraku;

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
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	private UserRepository repo;
	@PostMapping("/registerme")
	public String e(@RequestParam("password") String password, @RequestParam("username") String username,
			HttpServletRequest request) throws Exception {
		if (repository.findByUsername(username) != null) {
			throw new Exception("Already registered");
		}
		User us = new User();
		us.setAuthorities(new ArrayList<GrantedAuthority>());
		us.setRoles(new ArrayList<Role>());
		us.setUsername(username);
		BCryptPasswordEncoder e = new BCryptPasswordEncoder();

		us.setPassword(e.encode(password));
		us.setAccountNonExpired(true);
		us.setAccountNonLocked(true);
		us.setEnabled(true);
		us.setCredentialsNonExpired(true);
		repository.save(us);
		authenticateUserAndSetSession(us, request,password);
		return "redirect:/q";
	}

	@Autowired
	protected AuthenticationManager authenticationManager;

	private void authenticateUserAndSetSession(User user, HttpServletRequest request,String password) throws ServletException {
		String username =user.getUsername();
		
		UserDetails userDetails = repo.findByUsername(username);
	    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

	    Authentication auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

	    if (auth.isAuthenticated()) {
	        SecurityContextHolder.getContext().setAuthentication(auth);
	        
	    }

	}
}
