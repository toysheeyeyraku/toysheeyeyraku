package org.toysheeyeyraku.controllers;

import java.security.Principal;
import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.toysheeyeyraku.models.EveryDayEvent;
import org.toysheeyeyraku.models.User;
import org.toysheeyeyraku.models.UserSchedule;
import org.toysheeyeyraku.repositories.ScheduleRepository;
import org.toysheeyeyraku.repositories.UserRepository;
import org.toysheeyeyraku.services.ScheduleService;

@Controller

public class EveryDayEventController {
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ScheduleRepository scheduleRepository;
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
		return "redirect:/creation";
	}
	@GetMapping("creation")
	public String getCreation(Model m,Principal p) {
		User user =userRepository.findByUsername(p.getName());
		UserSchedule schedule =scheduleRepository.findByUserId(user.getId());
		if (schedule==null) {
			schedule=UserSchedule.createDevUserChedule(user.getId());
			scheduleRepository.save(schedule);
		}
		ArrayList<EveryDayEvent> everyDayevents =schedule.getEveryDayEvents();
		m.addAttribute("everyDayEvents", everyDayevents);
		m.addAttribute("login",user.getUsername());
		return "creation1";
	}
}
