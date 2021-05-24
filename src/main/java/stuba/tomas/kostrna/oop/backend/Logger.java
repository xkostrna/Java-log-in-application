package stuba.tomas.kostrna.oop.backend;

import stuba.tomas.kostrna.oop.frontend.MainWindow;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Logger {
    UsersDatabase database;
    MainWindow window;

    public Logger(MainWindow window) throws IOException {
        this.window = window;
        this.database = new UsersDatabase();
    }

    public void handleEvent(ActionEvent event) {
        if (event.getActionCommand().equals(this.window.getLogPanel().getLogInButton().getActionCommand())) {
            String username = this.window.getLogPanel().getUsernameInput().getText();
            String password = Arrays.toString(this.window.getLogPanel().getPasswordInput().getPassword());
            Map<String, String> logData = this.database.getLogData();
            for (Map.Entry<String, String> entry : logData.entrySet()) {
                if (entry.getKey().equals(username) && entry.getValue().equals(password)) {
                    System.out.println("LOGGED IN");
                }
            }
        }
    }
}
