package stuba.tomas.kostrna.oop.frontend.afterlogin;

import lombok.Getter;
import lombok.Setter;
import stuba.tomas.kostrna.oop.backend.User;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class UserInterface extends JFrame {
    private User user;
    public UserInterface(User user) {
        super("Greetings " + user.getUsername());
        initializeDefault();
    }
    private void initializeDefault() {
        this.setVisible(true);
        this.setFocusable(true);
        this.setMinimumSize(new Dimension(300,100));
    }
}
