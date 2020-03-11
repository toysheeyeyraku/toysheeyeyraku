package org.toysheeyeyraku;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.toysheeyeyraku.models.Role;
import org.toysheeyeyraku.models.User;
import org.toysheeyeyraku.models.UserSchedule;
import org.toysheeyeyraku.repositories.ScheduleRepository;
import org.toysheeyeyraku.repositories.UserRepository;
import org.toysheeyeyraku.services.BaseJustify;



/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
//@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class StartApp extends SpringBootServletInitializer implements CommandLineRunner  {
	
	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(StartApp.class, args);
	}
	@Autowired
	private ScheduleRepository rep;
	public void run(String... args) throws Exception {
		
		//UserSchedule s =UserSchedule.createDevUserChedule();
		//rep.save(s);
		//base.createTelegramSettings();
	}
	@Autowired
	private BaseJustify base;

	
		
	}

