package stuba.tomas.kostrna.oop.backend;

import lombok.Getter;
import lombok.Setter;
import stuba.tomas.kostrna.oop.frontend.homepage.MainWindow;
import stuba.tomas.kostrna.oop.frontend.afterlogin.UserInterface;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Getter
@Setter
public class Logger {
    private UsersDatabase database;
    private MainWindow window;
    private Response response;

    public Logger(MainWindow window) throws IOException {
        this.window = window;
        this.response = new Response();
        this.database = new UsersDatabase();
    }

    public boolean handleEvent(ActionEvent event) {
        if (event.getActionCommand().equals(this.window.getLogPanel().getLogInButton().getActionCommand())) {
            String username = this.window.getLogPanel().getUsernameInput().getText();
            String password = Arrays.toString(this.window.getLogPanel().getPasswordInput().getPassword());
            Map<String, String> logData = this.database.getLogData();
            for (Map.Entry<String, String> entry : logData.entrySet()) {
                if (entry.getKey().equals(username) && Arrays.toString(entry.getValue().toCharArray()).equals(password)) {
                    clearInputs();
                    new UserInterface(new User(entry));
                    return this.response.logInSuccessful();
                }
            }
            return this.response.wrongLogInfo();
        }
        return false;
    }

    private void clearInputs() {
        this.window.getLogPanel().getUsernameInput().setText("");
        this.window.getLogPanel().getPasswordInput().setText("");
    }
}
