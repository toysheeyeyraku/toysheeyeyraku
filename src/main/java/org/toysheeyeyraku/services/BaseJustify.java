package org.toysheeyeyraku.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.toysheeyeyraku.models.TelegramSettings;
import org.toysheeyeyraku.models.User;
import org.toysheeyeyraku.models.UserSchedule;
import org.toysheeyeyraku.repositories.ScheduleRepository;
import org.toysheeyeyraku.repositories.TelegramSettingsRepository;
import org.toysheeyeyraku.repositories.UserRepository;

import lombok.extern.apachecommons.CommonsLog;

@Component
public class BaseJustify {
	@Autowired
	private TelegramSettingsRepository telegramrepository ;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ScheduleRepository scheduleRepository;
	public void createTelegramSettings() {
		telegramrepository.deleteAll();
		for (User user :userRepository.findAll()) {
			if (telegramrepository.findByUserId(user.getId())==null) {
				TelegramSettings settings =new TelegramSettings();
				settings.setRegisterString(user.getId().toString());
				settings.setUserId(user.getId());
				telegramrepository.save(settings);
			}
		}
	}
}
