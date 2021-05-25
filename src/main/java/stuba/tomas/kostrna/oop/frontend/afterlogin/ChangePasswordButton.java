package stuba.tomas.kostrna.oop.frontend.afterlogin;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class ChangePasswordButton extends JButton {
    public ChangePasswordButton() {
        super("Change password");
    }
}
