package org.toysheeyeyraku.services;

import java.time.LocalTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.toysheeyeyraku.models.EveryDayEvent;
import org.toysheeyeyraku.models.TelegramSettings;
import org.toysheeyeyraku.models.UserSchedule;
import org.toysheeyeyraku.repositories.ScheduleRepository;
import org.toysheeyeyraku.repositories.TelegramSettingsRepository;
import org.toysheeyeyraku.telegrambot.Bot;

@Service
public class ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Autowired
	private TelegramSettingsRepository telegramRepository;
	@Autowired
	private Bot bot;
	@Scheduled(fixedRate = 500)
	public void reportCurrentTime() {
		List<UserSchedule> list = scheduleRepository.findAll();
		for (UserSchedule schedule : list) {
			for (EveryDayEvent everyday : schedule.getEveryDayEvents()) {
				if (everyday.isSended() == true) {
					continue;
				}
				LocalTime time1 = LocalTime.now();
				LocalTime time2 = everyday.getTime();
				int value = time1.compareTo(time2);
				if (value > 0) {
					System.out.println("WOI");
					TelegramSettings settings=telegramRepository.findByUserId(schedule.getUserId());
					if (settings==null) {
						settings=new TelegramSettings();
						settings.setUserId(schedule.getUserId());
						settings.setRegisterString(schedule.getUserId().toString());
						telegramRepository.save(settings);
					}
					if (settings.getChatId()!=null) {
						bot.sendMsg(settings.getChatId(),everyday.getDescription() );
						
					}
					everyday.setSended(true);
				}
			}
			scheduleRepository.save(schedule);

		}

	}

	public void addEveryDayEvent(EveryDayEvent event, ObjectId user) {
		UserSchedule sc = scheduleRepository.findByUserId(user);
		if (sc==null) {
			sc=UserSchedule.createDevUserChedule(user);
		}
		sc.getEveryDayEvents().add(event);
		scheduleRepository.save(sc);
	}

	public void dayChanged() {
		List<UserSchedule> list = scheduleRepository.findAll();
		for (UserSchedule schedule : list) {
			for (EveryDayEvent everyday : schedule.getEveryDayEvents()) {
				everyday.setSended(false);
			}
			scheduleRepository.save(schedule);

		}
	}
}
