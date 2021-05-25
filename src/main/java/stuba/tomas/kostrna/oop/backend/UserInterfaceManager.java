package stuba.tomas.kostrna.oop.backend;

import lombok.Getter;
import lombok.Setter;
import stuba.tomas.kostrna.oop.frontend.afterlogin.UserInterface;

import java.io.*;

@Getter
@Setter
public class UserInterfaceManager {
    private UserInterface userInterface;

    public UserInterfaceManager(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void handleChangePasswordEvent() {
        StringBuilder newPassword = new StringBuilder();
        newPassword.append(this.getUserInterface().getEnterPasswordField().getPassword());
        this.getUserInterface().getEnterPasswordField().setText("");
        try {
            File file = new File("src\\main\\java\\stuba\\tomas\\kostrna\\oop\\backend\\logdata.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder newContent = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                String[] userData = line.split(" ");
                if (userData[0].equals(this.getUserInterface().getUser().getUsername())) {
                    if (userData[1].equals(this.getUserInterface().getUser().getPassword())) {
                        userData[1] = newPassword.toString();
                    }
                }
                newContent.append(userData[0]).append(" ").append(userData[1]).append(System.lineSeparator());
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
    }

}
