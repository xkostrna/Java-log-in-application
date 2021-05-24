package stuba.tomas.kostrna.oop;

import lombok.Getter;
import lombok.Setter;
import stuba.tomas.kostrna.oop.backend.UsersDatabase;
import stuba.tomas.kostrna.oop.frontend.MainWindow;

import java.io.IOException;

@Getter
@Setter
public class Application {
    private MainWindow mainWindow;
    private UsersDatabase usersDatabase;

    public Application() throws IOException {
        this.mainWindow = new MainWindow();
        try {
            this.usersDatabase = new UsersDatabase();
        }
        catch (IOException e) {
            throw new IOException();
        }
    }
}
