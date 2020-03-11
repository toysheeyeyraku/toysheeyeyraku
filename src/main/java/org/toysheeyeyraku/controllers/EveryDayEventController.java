package org.toysheeyeyraku.controllers;

import java.security.Principal;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.toysheeyeyraku.models.EveryDayEvent;
import org.toysheeyeyraku.models.User;
import org.toysheeyeyraku.repositories.UserRepository;
import org.toysheeyeyraku.services.ScheduleService;

@Controller

public class EveryDayEventController {
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private UserRepository userRepository;
	@PostMapping("createEveryDayEvent")
	public String getP(@RequestParam("text") String text ,@RequestParam("time") String time,Principal p) {
		LocalTime w=LocalTime.parse(time);
		User user=userRepository.findByUsername(p.getName());
		EveryDayEvent event =new EveryDayEvent();
		event.setTime(w);
		event.setSended(false);
		event.setDescription(text);
		event.setName("name");
		scheduleService.addEveryDayEvent(event, user.getId());
		return "creation";
	}
	@GetMapping("creation")
	public String getCreation() {
		return "creation";
	}
}
