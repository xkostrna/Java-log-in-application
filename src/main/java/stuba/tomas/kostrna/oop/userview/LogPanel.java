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

    public LogPanel() {
        super();
        initializeDefaultSettings();
    }

    private void initializeDefaultSettings() {
        this.setSize(100,200);
        this.setLayout(new GridLayout(2,2));

        this.add(new JLabel("username : "));
        this.usernameInput = new UsernameInput();
        this.add(this.usernameInput);


        this.add(new JLabel("password: "));
        this.passwordInput = new PasswordInput();
        this.add(this.passwordInput);
    }

}
