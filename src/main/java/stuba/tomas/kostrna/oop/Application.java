package stuba.tomas.kostrna.oop;

import stuba.tomas.kostrna.oop.backend.UserLogManager;
import stuba.tomas.kostrna.oop.frontend.MainWindow;

import java.io.IOException;

public class Application {
    private MainWindow mainWindow;
    private UserLogManager userManager;

    public Application() throws IOException {
        this.mainWindow = new MainWindow();
        try {
            this.userManager = new UserLogManager();
        }
        catch (IOException e) {
            throw new IOException();
        }
    }
}
