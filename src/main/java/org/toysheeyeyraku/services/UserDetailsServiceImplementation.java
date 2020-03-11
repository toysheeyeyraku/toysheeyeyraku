package org.toysheeyeyraku.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.toysheeyeyraku.models.User;
import org.toysheeyeyraku.repositories.UserRepository;


@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
	}
 
    
}