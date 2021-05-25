package stuba.tomas.kostrna.oop.frontend.afterlogin;

import lombok.Getter;
import lombok.Setter;
import stuba.tomas.kostrna.oop.backend.User;
import stuba.tomas.kostrna.oop.backend.UserInterfaceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
public class UserInterface extends JFrame implements ActionListener {

    private User user;
    private ChangePasswordButton changePasswordButton;
    private JPasswordField enterPasswordField;
    private UserInterfaceManager manager;

    public UserInterface(User user) {
        super(user.getUsername() + " interface :)");
        this.user = user;
        this.manager = new UserInterfaceManager(this);
        initializeDefaultFrontendSettings();
    }

    private void initializeDefaultFrontendSettings() {
        this.setVisible(true);
        this.setFocusable(true);
        this.setMinimumSize(new Dimension(500,75));
        this.setLayout(new GridLayout(0,3));

        this.add(new JLabel("Enter new password: "));
        this.enterPasswordField = new JPasswordField();
        this.enterPasswordField.setMinimumSize(new Dimension(70,100));
        this.add(this.enterPasswordField);

        this.changePasswordButton = new ChangePasswordButton();
        this.changePasswordButton.addActionListener(this);
        this.add(this.changePasswordButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(this.changePasswordButton.getActionCommand())) {
            if (this.enterPasswordField.getPassword() != null) {
                this.manager.handleChangePasswordEvent();
            }
        }
    }

}
