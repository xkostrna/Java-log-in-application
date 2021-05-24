package stuba.tomas.kostrna.oop.frontend;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MainWindow extends JFrame {

    private LogPanel logPanel;

    private int DEFAULT_WIDTH = 325;
    private int DEFAULT_HEIGHT = 400;

    public MainWindow() {
        super("Tomas Kostrna Project");
        initializeMainWindow();
        initializeLogPanel();
    }

    private void initializeMainWindow() {
        this.setVisible(true);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
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
