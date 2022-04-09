package net.jungly.coins.user;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.jungly.coins.mongo.repository.MongoObjectRepository;
import net.jungly.coins.mongo.repository.ObjectRepository;
import lombok.Getter;

@Getter
public class UserManager {

    private final ObjectRepository<User> userObjectRepository;

    public UserManager(MongoDatabase database) {
        MongoCollection<User> collection = database.getCollection(
                "users",
                User.class
        );
        userObjectRepository = new MongoObjectRepository<>(collection);
    }
}
