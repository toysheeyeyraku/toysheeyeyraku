package org.toysheeyeyraku.models;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class EveryWeekEvent {
	@Id
	private ObjectId id;
	private DayOfWeek day;
	private LocalTime time ;
	private boolean sended;
}
