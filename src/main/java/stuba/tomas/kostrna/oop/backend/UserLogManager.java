package stuba.tomas.kostrna.oop.backend;

import java.io.IOException;

public class UserLogManager {
    private UsersDatabase usersDatabase;

    public UserLogManager() throws IOException {
        this.usersDatabase = new UsersDatabase();
    }
}
