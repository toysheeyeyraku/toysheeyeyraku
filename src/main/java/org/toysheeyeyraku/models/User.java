package org.toysheeyeyraku.models;

import java.util.ArrayList;
import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
@Document("Credentials")
public class User implements UserDetails {
	@Id
	private ObjectId id;
	private String password;
	private String username;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean  isEnabled;
	private ArrayList<GrantedAuthority> authorities;
	private ArrayList<Role> roles;
	public static User createDefaultUser(String username,String password,PasswordEncoder encoder) {
		User us =new User();
		us.setAuthorities(new ArrayList<GrantedAuthority>());
		us.setRoles(new ArrayList<Role>());
		us.setUsername(username);
		us.setPassword(encoder.encode(password));
		us.setAccountNonExpired(true);
		us.setAccountNonLocked(true);
		us.setEnabled(true);
		us.setCredentialsNonExpired(true);
		return us;
	}

}
