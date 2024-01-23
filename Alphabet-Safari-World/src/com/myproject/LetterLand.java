package com.myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LetterLand extends JFrame {

    public LetterLand() {
        setTitle("LetterLand");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //  panel for circular buttons with empty borders
        JPanel buttonPanel = new JPanel(new GridLayout(4, 7, 10, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // circular buttons for A-Z
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            JButton circularButton = createCircularButton(String.valueOf(letter));
            buttonPanel.add(circularButton);
        }

        // the layout manager for the main frame
        setLayout(new BorderLayout());

        //  a JPanel for the upper space
        JPanel upperPanel = new JPanel();
        upperPanel.setOpaque(false);
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel playLabel = new JLabel(" *~* ALPHABET SAFARI WORLD *~* ");
        playLabel.setFont(new Font("Arial", Font.BOLD, 30));
        playLabel.setForeground(Color.black);
        upperPanel.add(playLabel);

        //background image
        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Alphabet-Safari-World\\src\\com\\myproject\\bg1.gif"));

        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel);

       
        backgroundLabel.add(upperPanel, BorderLayout.NORTH);
        backgroundLabel.add(buttonPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    private JButton createCircularButton(String label) {
        JButton button = new JButton(label);
        button.setPreferredSize(new Dimension(50, 50));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.black);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add custom action for button click if needed
                JOptionPane.showMessageDialog(null, "GOOD JOB!! You clicked on: " + label + ". Now, CLICK ON ANOTHER ALPHABET.");
            }
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LetterLand();
            }
        });
    }
}

