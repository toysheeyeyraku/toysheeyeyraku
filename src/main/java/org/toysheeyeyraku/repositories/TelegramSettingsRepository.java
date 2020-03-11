package org.toysheeyeyraku.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.toysheeyeyraku.models.TelegramSettings;

public interface TelegramSettingsRepository extends MongoRepository<TelegramSettings, ObjectId> {

	public TelegramSettings findByUserId(ObjectId userId);
	public TelegramSettings findByRegisterString(String registerString);
}
