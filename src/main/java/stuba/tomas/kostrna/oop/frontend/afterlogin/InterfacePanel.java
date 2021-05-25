package stuba.tomas.kostrna.oop.frontend.afterlogin;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class InterfacePanel extends JPanel {

    private ChangePasswordButton changePasswordButton;
    private JPasswordField enterPasswordField;

    private static int DEF_WIDTH = 200;
    private static int DEF_HEIGHT = 70;

    public InterfacePanel() {
        super();
        initializePanelSettings();
        initializeDefaultComponents();
    }

    private void initializePanelSettings() {
        this.setLayout(new GridLayout(0,3));
        this.setVisible(true);
        this.setMinimumSize(new Dimension());
    }

    private void initializeDefaultComponents() {
        this.changePasswordButton = new ChangePasswordButton();
        this.enterPasswordField = new JPasswordField();

        this.add(new JLabel("Enter new password: "));
        this.add(this.enterPasswordField);
        this.add(this.changePasswordButton);
    }
}
