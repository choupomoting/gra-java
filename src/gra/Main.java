package gra;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        panel gamePanel = new panel();
        window.add(gamePanel);
        window.pack();
        window.setVisible(true);
        gamePanel.startGameThread();
        gamePanel.run();
    }
}