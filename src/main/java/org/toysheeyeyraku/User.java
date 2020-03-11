package org.toysheeyeyraku;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.Data;

@Data
@Document("Credentials")
public class User implements UserDetails {
	
	private String password;
	private String username;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean  isEnabled;
	private ArrayList<GrantedAuthority> authorities;
	private ArrayList<Role> roles;
	

}
