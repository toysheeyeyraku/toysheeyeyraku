package org.toysheeyeyraku.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.toysheeyeyraku.models.User;
import org.toysheeyeyraku.models.UserSchedule;

public interface ScheduleRepository extends MongoRepository<UserSchedule, ObjectId> {

	public UserSchedule findByUserId(ObjectId userId);

}
