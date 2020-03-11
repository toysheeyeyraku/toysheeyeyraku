package org.toysheeyeyraku;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class StartApp extends SpringBootServletInitializer implements CommandLineRunner  {
	@Autowired
	private UserRepository rep;
	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(StartApp.class, args);
	}
	public void run(String... args) throws Exception {
		User us =new User();
		us.setAuthorities(new ArrayList<GrantedAuthority>());
		us.setRoles(new ArrayList<Role>());
		us.setUsername("user");
		BCryptPasswordEncoder e =new BCryptPasswordEncoder();
		
		us.setPassword(e.encode("user"));
		us.setAccountNonExpired(true);
		us.setAccountNonLocked(true);
		us.setEnabled(true);
		us.setCredentialsNonExpired(true);
		//rep.save(us);
		
	}

	
		
	}

