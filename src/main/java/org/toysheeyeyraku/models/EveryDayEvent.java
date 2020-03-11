package org.toysheeyeyraku.models;

import java.time.LocalTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class EveryDayEvent {
	@Id
	private ObjectId id;
	private LocalTime time;
	private boolean sended;
	private String name ;
	private String description ;
}
