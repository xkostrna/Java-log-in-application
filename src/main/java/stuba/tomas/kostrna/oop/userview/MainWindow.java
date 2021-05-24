package stuba.tomas.kostrna.oop.userview;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class MainWindow extends JFrame {

    private LogPanel logPanel;

    public MainWindow() {
        super("Tomas Kostrna Project");
        initializeMainWindow();
    }

    private void initializeMainWindow() {
        this.setVisible(true);
        this.setFocusable(true);
        this.setSize(300,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.logPanel = new LogPanel();
        this.add(this.logPanel);
        reDrawMainWindow();
    }

    private void reDrawMainWindow() {
        this.revalidate();
        this.repaint();
    }

}
