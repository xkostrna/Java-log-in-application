package stuba.tomas.kostrna.oop.userview;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MainWindow extends JFrame {

    private LogPanel logPanel;

    public MainWindow() {
        super("Tomas Kostrna Project");
        initializeMainWindow();
        initializeLogPanel();
    }

    private void initializeMainWindow() {
        this.setVisible(true);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(300,400));
        this.setMinimumSize(new Dimension(300,400));
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void reDrawMainWindow() {
        this.revalidate();
        this.repaint();
    }

    private void initializeLogPanel() {
        this.logPanel = new LogPanel();
        this.add(this.logPanel);
        reDrawMainWindow();
    }

}
