package org.toysheeyeyraku.models;

import java.time.LocalTime;
import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class UserSchedule {
	@Id
	private ObjectId id;
	private ArrayList<EveryDayEvent> everyDayEvents;
	private ArrayList<EveryWeekEvent> everyWeekEvents;
	private ArrayList<OnceEvent> OnceEvents;
	private ObjectId userId;
	public static UserSchedule createDevUserChedule(ObjectId id) {
		UserSchedule ans =new UserSchedule();
		ans.setUserId(id);
		ans.setEveryDayEvents(new ArrayList<EveryDayEvent>());
		ans.setEveryWeekEvents(new ArrayList<EveryWeekEvent>());
		ans.setOnceEvents(new ArrayList<OnceEvent>() );
		return ans;
	}
}
