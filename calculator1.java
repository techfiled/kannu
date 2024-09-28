import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class calculator1 implements ActionListener {

    JFrame frame;
    JPanel panel;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
    GridBagLayout gb;
    GridBagConstraints gbc;
    JLabel label;
    JLabel usertext;

    // Variables to manage calculator state
    String currentText = "0";
    String firstOperand = "";
    String currentOperation = "";
    boolean isNewNumber = true;

    public calculator1() {
        JFrame frame = new JFrame("Calculator");
        JPanel panel = new JPanel();

        label = new JLabel();
        usertext = new JLabel("0");

        // Initialize buttons
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("/");
        b5 = new JButton("4");
        b6 = new JButton("5");
        b7 = new JButton("6");
        b8 = new JButton("+");
        b9 = new JButton("7");
        b10 = new JButton("8");
        b11 = new JButton("9");
        b12 = new JButton("-");
        b13 = new JButton("*");
        b14 = new JButton("0");
        b15 = new JButton("=");

        // Set button backgrounds
        b1.setBackground(new Color(102, 178, 255));
        b2.setBackground(new Color(102, 178, 255));
        b3.setBackground(new Color(102, 178, 255));
        b4.setBackground(new Color(204, 204, 255));
        b5.setBackground(new Color(102, 178, 255));
        b6.setBackground(new Color(102, 178, 255));
        b7.setBackground(new Color(102, 178, 255));
        b8.setBackground(new Color(204, 204, 255));
        b9.setBackground(new Color(102, 178, 255));
        b10.setBackground(new Color(102, 178, 255));
        b11.setBackground(new Color(102, 178, 255));
        b12.setBackground(new Color(204, 204, 255));
        b13.setBackground(new Color(204, 204, 255));
        b14.setBackground(new Color(102, 178, 255));
        b15.setBackground(new Color(204, 204, 255));

        // Initialize layout and add components
        gbc = new GridBagConstraints();
        gb = new GridBagLayout();
        panel.setLayout(gb);
        frame.add(panel);

        // Set up initial display
        gbc.insets = new Insets(2, 2, 10, 10);
        gbc.ipadx = 60;
        gbc.ipady = 40;
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(usertext, gbc);

        // Add action listeners to buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);

        // Add buttons to panel with grid layout
        // (GridBagConstraints settings omitted for brevity)
        panel.add(b1, gbc);
        panel.add(b2, gbc);
        panel.add(b3, gbc);
        panel.add(b4, gbc);
        panel.add(b5, gbc);
        panel.add(b6, gbc);
        panel.add(b7, gbc);
        panel.add(b8, gbc);
        panel.add(b9, gbc);
        panel.add(b10, gbc);
        panel.add(b11, gbc);
        panel.add(b12, gbc);
        panel.add(b13, gbc);
        panel.add(b14, gbc);
        panel.add(b15, gbc);

        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();

        if (buttonText.matches("[0-9]")) {
            // Handle numeric buttons
            if (isNewNumber) {
                usertext.setText(buttonText);
                isNewNumber = false;
            } else {
                usertext.setText(usertext.getText() + buttonText);
            }
        } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
            // Handle operator buttons
            firstOperand = usertext.getText();
            currentOperation = buttonText;
            isNewNumber = true;
        } else if (buttonText.equals("=")) {
            // Handle equals button
            if (!isNewNumber) {
                String secondOperand = usertext.getText();
                double result = calculateResult(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand), currentOperation);
                usertext.setText(String.valueOf(result));
                isNewNumber = true;
            }
        }
    }

    // Method to perform the arithmetic calculation
    private double calculateResult(double firstOperand, double secondOperand, String operation) {
        switch (operation) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    // Division by zero error handling (not implemented here)
                    return 0;
                }
            default:
                return 0;
        }
    }
    public static void main(String[] args) {
        new calculator1();
    }
}
