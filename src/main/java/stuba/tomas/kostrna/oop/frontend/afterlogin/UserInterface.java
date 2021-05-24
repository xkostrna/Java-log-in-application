package stuba.tomas.kostrna.oop.frontend.afterlogin;

import lombok.Getter;
import lombok.Setter;
import stuba.tomas.kostrna.oop.backend.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

@Getter
@Setter
public class UserInterface extends JFrame implements ActionListener {

    private User user;
    private ChangePassword changePasswordButton;
    private JPasswordField enterPasswordField;

    public UserInterface(User user) {
        super(user.getUsername() + " interface :)");
        this.user = user;
        initializeDefault();
    }

    private void initializeDefault() {
        this.setVisible(true);
        this.setFocusable(true);
        this.setMinimumSize(new Dimension(500,75));
        this.setLayout(new GridLayout(0,3));

        this.add(new JLabel("Enter new password: "));
        this.enterPasswordField = new JPasswordField();
        this.enterPasswordField.setMinimumSize(new Dimension(70,100));
        this.add(this.enterPasswordField);

        this.changePasswordButton = new ChangePassword();
        this.changePasswordButton.addActionListener(this);
        this.add(this.changePasswordButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(this.changePasswordButton.getActionCommand())) {
            if (this.enterPasswordField.getPassword() != null) {
                changeUserPassword();
            }
        }
    }

    private void changeUserPassword() {
        StringBuilder newPassword = new StringBuilder();
        newPassword.append(this.enterPasswordField.getPassword());
        this.enterPasswordField.setText("");
        try {
            File file = new File("src\\main\\java\\stuba\\tomas\\kostrna\\oop\\backend\\logdata.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder newContent = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                String[] userData = line.split(" ");
                if (userData[0].equals(this.user.getUsername())) {
                    if (userData[1].equals(this.user.getPassword())) {
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
