package ca.bcit.comp2522.labs.lab04;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class TelephonePanel extends JPanel {

    /**
     * Telephone panel.
     */
    public TelephonePanel() {
        JButton button0 = new JButton("0");
        JButton poundButton = new JButton("#");
        JButton starButton = new JButton("*");
        NumberListener listener = new NumberListener();
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Your Telephone");
        add(title, BorderLayout.NORTH);
        GridLayout layout = new GridLayout(4, 3);
        JPanel panel = new JPanel(layout);

        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton("" + i);
            panel.add(button);
            button.addActionListener(listener);
        }
        panel.add(starButton);
        panel.add(button0);
        panel.add(poundButton);

        starButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.out.println("key pressed: *");
            }
        });
        button0.addActionListener(listener);
        poundButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.out.println("key pressed: #");
            }
        });

        add(panel, BorderLayout.CENTER);
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
    }

    class NumberListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            String text = e.getActionCommand();
            System.out.println("key pressed: " + text);
        }
    }


}
