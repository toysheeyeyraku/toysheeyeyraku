package org.toysheeyeyraku.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.toysheeyeyraku.models.TelegramSettings;
import org.toysheeyeyraku.models.User;
import org.toysheeyeyraku.repositories.TelegramSettingsRepository;
import org.toysheeyeyraku.repositories.UserRepository;

@Controller
public class IndexController {
	@Autowired
	private TelegramSettingsRepository rep;
	@Autowired
	private UserRepository userRep;
	@GetMapping("/")
	public String getIndex(Model m,Principal p) {
		User user=userRep.findByUsername(p.getName());
		TelegramSettings set=rep.findByUserId(user.getId());
		if (set==null) {
			set=new TelegramSettings();
			set.setRegisterString(user.getId().toString());
			set.setUserId(user.getId());
			rep.save(set);
		}
		m.addAttribute("message",set.getRegisterString());
		m.addAttribute("user", user.getUsername());
		return "index";
	}
}
