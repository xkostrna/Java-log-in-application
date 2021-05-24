package stuba.tomas.kostrna.oop.frontend.homepage;

import lombok.Getter;
import lombok.Setter;
import stuba.tomas.kostrna.oop.backend.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

@Getter
@Setter
public class MainWindow extends JFrame implements ActionListener {

    private LogPanel logPanel;
    private Logger logger;

    private int DEFAULT_WIDTH = 325;
    private int DEFAULT_HEIGHT = 400;

    public MainWindow() throws IOException {
        super("Tomas Kostrna Project");
        initializeMainWindow();
        initializeLogPanel();
        initializeVariables();
    }

    private void initializeVariables() throws IOException {
        this.logger = new Logger(this);
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
        this.logPanel.getLogInButton().addActionListener(this);
        this.add(this.logPanel);
        reDrawMainWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(logger.handleEvent(e));
    }
}
