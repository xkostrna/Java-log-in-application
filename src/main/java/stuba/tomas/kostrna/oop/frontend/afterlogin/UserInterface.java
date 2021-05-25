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
    private InterfacePanel interfacePanel;
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
        this.setMinimumSize(new Dimension(500,100));
        this.setLayout(new FlowLayout());

        this.interfacePanel = new InterfacePanel();
        this.getInterfacePanel().getChangePasswordButton().addActionListener(this);
        this.add(interfacePanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(this.interfacePanel.getChangePasswordButton().getActionCommand())) {
            if (this.interfacePanel.getEnterPasswordField().getPassword() != null) {
                this.manager.handleChangePasswordEvent();
            }
        }
    }
}
