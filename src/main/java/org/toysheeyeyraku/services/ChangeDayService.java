package org.toysheeyeyraku.services;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ChangeDayService {
	private LocalDate date =LocalDate.now();
	@Autowired
	private ScheduleService scheduleService;
	@Scheduled(fixedRate = 50000)
	public void checkDate() {
		if (!date.equals(LocalDate.now())) {
			scheduleService.dayChanged();
			date=LocalDate.now();
			
		}
	}
}
