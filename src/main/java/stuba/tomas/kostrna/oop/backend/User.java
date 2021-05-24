package stuba.tomas.kostrna.oop.backend;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class User {
    private String username;
    private String password;

    public User(Map.Entry<String, String> init) {
        this.username = init.getKey();
        this.password = init.getValue();
    }
}
