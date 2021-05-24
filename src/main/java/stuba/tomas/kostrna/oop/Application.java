package stuba.tomas.kostrna.oop;

import lombok.Getter;
import lombok.Setter;
import stuba.tomas.kostrna.oop.backend.UserLogManager;
import stuba.tomas.kostrna.oop.frontend.MainWindow;

import java.io.IOException;

@Getter
@Setter
public class Application {
    private MainWindow mainWindow;
    private UserLogManager userManager;
    private ApplicationManager manager;

    public Application() throws IOException {
        this.mainWindow = new MainWindow();
        try {
            this.userManager = new UserLogManager();
        }
        catch (IOException e) {
            throw new IOException();
        }
        this.manager = new ApplicationManager(this);
    }
}
