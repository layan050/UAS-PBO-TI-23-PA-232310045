package com.PBO.finalProject.Play;
import com.PBO.finalProject.Game.Game;
import com.PBO.finalProject.Menu.Menu;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.Random;

public class Play extends JPanel {

    final Game game;
    private int correctAnswer;
    private JLabel hintLabel, statusLabel, scoreLabel;
    private JTextField guessInput;
    private int attempts = 0;

    public Play(Game game) {
        this.game = game;

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        startGame();
        createGUI();
    }

    private void startGame() {
        Random random = new Random();
        correctAnswer = random.nextInt(100) + 1; // Generate random number between 1-100
    }

    private void createGUI() {
        removeAll(); // Clear previous components to prevent duplication

        scoreLabel = new JLabel("Attempts: " + attempts);
        scoreLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        scoreLabel.setForeground(new Color(200, 0, 0)); // Red tone
        scoreLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(scoreLabel);

        JLabel title = new JLabel("Guess the Number", JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 30));
        title.setForeground(new Color(255, 0, 0)); // Bright red
        title.setBorder(new EmptyBorder(50, 0, 20, 0));
        title.setAlignmentX(CENTER_ALIGNMENT);
        add(title);

        hintLabel = new JLabel("Hint: The number is close to " + getHint());
        hintLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        hintLabel.setForeground(new Color(200, 50, 50)); // Softer red
        hintLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(hintLabel);

        guessInput = new JTextField();
        guessInput.setFont(new Font("MV Boli", Font.BOLD, 20));
        guessInput.setHorizontalAlignment(JTextField.CENTER);
        guessInput.setMaximumSize(new Dimension(200, 50));
        guessInput.setBackground(new Color(255, 200, 200)); // Light red background
        guessInput.setForeground(new Color(150, 0, 0)); // Dark red text
        add(guessInput);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        submitButton.setBackground(new Color(255, 100, 100)); // Medium red
        submitButton.setForeground(new Color(50, 0, 0)); // Deep red
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.setAlignmentX(CENTER_ALIGNMENT);
        submitButton.addActionListener(e -> checkGuess());
        add(submitButton);

        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        statusLabel.setForeground(new Color(200, 0, 0)); // Red for status messages
        statusLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(statusLabel);

        JButton menuButton = new JButton("Back to Menu");
        menuButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        menuButton.setBackground(new Color(255, 150, 150)); // Softer red
        menuButton.setForeground(new Color(100, 0, 0)); // Dark red text
        menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuButton.setAlignmentX(CENTER_ALIGNMENT);
        menuButton.addActionListener(e -> game.showView(new Menu(game)));
        add(menuButton);

        revalidate(); // Ensure the layout is updated properly
        repaint(); // Redraw the panel
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessInput.getText());
            attempts++;
            scoreLabel.setText("Attempts: " + attempts);

            if (guess == correctAnswer) {
                statusLabel.setText("Correct! The number was " + correctAnswer + ".");
                hintLabel.setText("");
                guessInput.setEnabled(false);
            } else if (guess < correctAnswer) {
                statusLabel.setText("Too Low! Try Again.");
                hintLabel.setText("Hint: The number is close to " + getHint());
            } else {
                statusLabel.setText("Too High! Try Again.");
                hintLabel.setText("Hint: The number is close to " + getHint());
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Enter a valid number!");
        }

        guessInput.setText(""); // Clear the input field
    }

    private int getHint() {
        Random random = new Random();
        int offset = random.nextInt(20) - 10; // Offset to make hint ambiguous
        int hint = correctAnswer + offset;
        return Math.max(1, Math.min(100, hint)); // Ensure hint is between 1-100
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(255, 230, 230)); // Light red background
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
