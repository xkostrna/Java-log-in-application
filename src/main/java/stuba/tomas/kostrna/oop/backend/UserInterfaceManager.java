package stuba.tomas.kostrna.oop.backend;

import lombok.Getter;
import lombok.Setter;
import stuba.tomas.kostrna.oop.frontend.afterlogin.UserInterface;

import java.io.*;
import java.util.Map;

@Getter
@Setter
public class UserInterfaceManager {
    private UserInterface userInterface;
    private UsersDatabase database;

    private static int username = 0;
    private static int password = 1;

    public UserInterfaceManager(UserInterface userInterface, UsersDatabase database) {
        this.userInterface = userInterface;
        this.database = database;
    }

    public void changeUserPasswordInTextFile() {
        StringBuilder newPassword = new StringBuilder();
        newPassword.append(this.getUserInterface().getInterfacePanel().getEnterPasswordField().getPassword());
        this.getUserInterface().getInterfacePanel().getEnterPasswordField().setText("");
        try {
            File file = new File("src\\main\\java\\stuba\\tomas\\kostrna\\oop\\backend\\logdata.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder newContent = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                String[] userData = line.split(" ");
                if (userData[username].equals(this.getUserInterface().getUser().getUsername())) {
                    if (userData[password].equals(this.getUserInterface().getUser().getPassword())) {
                        userData[password] = newPassword.toString();
                    }
                }
                newContent.append(userData[username]).append(" ").append(userData[password]).append(System.lineSeparator());
                line = reader.readLine();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(newContent.toString());
            reader.close();
            writer.close();
        }
        catch (IOException exception) {
            System.out.println("not found");
        }
        changeUserPasswordInDatabase(newPassword.toString());
    }

    private void changeUserPasswordInDatabase(String newPassword) {
        User user = this.userInterface.getUser();
        Map<String, String> data = this.database.getLogData();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getKey().equals(user.getUsername())) {
                entry.setValue(newPassword);
            }
        }
    }
}
