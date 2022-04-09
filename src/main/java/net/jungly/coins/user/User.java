package net.jungly.coins.user;

import net.jungly.coins.mongo.model.Model;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class User implements Model {

    private final String id;

    private int coins;

    public User(String id) {
        this.id = id;
    }

    @ConstructorProperties({
            "id",
            "coins"
    })
    public User(
            String id,
            int coins
    ) {
        this(id);
        this.coins = coins;
    }

}
