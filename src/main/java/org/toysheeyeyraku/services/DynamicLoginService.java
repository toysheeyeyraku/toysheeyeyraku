package org.toysheeyeyraku.services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.toysheeyeyraku.repositories.UserRepository;
@Service
public class DynamicLoginService {
	@Autowired
	protected AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository repo;
	public void authenticateUserAndSetSession(String username, HttpServletRequest request,String password) throws ServletException {
		
		
		UserDetails userDetails = repo.findByUsername(username);
	    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

	    Authentication auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

	    if (auth.isAuthenticated()) {
	        SecurityContextHolder.getContext().setAuthentication(auth);
	        
	    }

	}
}
