package org.toysheeyeyraku.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class TelegramSettings {
	@Id
	private ObjectId id;
	private String chatId;
	private String registerString;
	private ObjectId userId;
}
