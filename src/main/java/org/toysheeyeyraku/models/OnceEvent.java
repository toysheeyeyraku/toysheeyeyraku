package org.toysheeyeyraku.models;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class OnceEvent {
	@Id
	private ObjectId id;
	private LocalDateTime currentDate;
	private boolean sended;
	private String description;
	private String name;
}
