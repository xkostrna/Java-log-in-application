package stuba.tomas.kostrna.oop.userview;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class LogPanel extends JPanel {
    private UsernameInput usernameInput;
    private PasswordInput passwordInput;

    private LogInButton logInButton;
    private ExitButton exitButton;

    public LogPanel() {
        super();
        initializeDefaultSettings();
    }

    private void initializeDefaultSettings() {
        this.setPreferredSize(new Dimension(250, 70));
        this.setLayout(new GridLayout(3,2));

        this.add(new JLabel("username: "));
        this.usernameInput = new UsernameInput();
        this.add(this.usernameInput);

        this.add(new JLabel("password: "));
        this.passwordInput = new PasswordInput();
        this.add(this.passwordInput);

        this.logInButton = new LogInButton();
        this.add(this.logInButton);

        this.exitButton = new ExitButton();
        this.add(this.exitButton);
    }

}
