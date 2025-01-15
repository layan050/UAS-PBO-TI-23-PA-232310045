package com.PBO.finalProject.Menu;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import com.PBO.finalProject.Game.Game;
import com.PBO.finalProject.Play.Play;


public class Menu extends JPanel {

    final Game game;

    public Menu(Game game) {
        this.game = game;

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        createGUI();
    }

    private void createGUI() {
        JLabel title = new JLabel("Guess the Number", JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 30));
        title.setForeground(new Color(253, 233, 180));
        title.setBorder(new EmptyBorder(100, 0, 50, 0));
        title.setAlignmentX(CENTER_ALIGNMENT);
        add(title);

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        startButton.setBackground(new Color(253, 233, 180));
        startButton.setForeground(new Color(125, 95, 123));
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startButton.setAlignmentX(CENTER_ALIGNMENT);
        startButton.addActionListener(e -> game.showView(new Play(game)));
        add(startButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("background.png").getImage(), 0, 0, null);
    }
}
