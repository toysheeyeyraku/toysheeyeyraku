package org.toysheeyeyraku.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.toysheeyeyraku.models.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {

	public User findByUsername(String username);

}
