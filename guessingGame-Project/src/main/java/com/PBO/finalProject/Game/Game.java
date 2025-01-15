package com.PBO.finalProject.Game;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.PBO.finalProject.Menu.*;
import com.PBO.finalProject.Menu.Menu;

import java.util.Random;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    JPanel viewPanel;

    public Game() {
        // Initialize the main game window
        viewPanel = new JPanel(new BorderLayout());

        this.setTitle("Guess the Number");
        this.setPreferredSize(new Dimension(400, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(viewPanel, BorderLayout.CENTER);

        // Start with the menu view
        showView(new Menu(this));

        this.setVisible(true);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null); // Center the window
    }

    // Change the current view in the game
    public void showView(JPanel jPanel) {
        SwingUtilities.invokeLater(() -> {
            viewPanel.removeAll();
            viewPanel.add(jPanel, BorderLayout.CENTER);
            viewPanel.revalidate();
            viewPanel.repaint();
        });
    }

    public static void main(String[] args) {
        new Game();
    }
}
