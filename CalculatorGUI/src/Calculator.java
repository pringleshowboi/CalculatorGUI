import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// The Calculator class extends JFrame to create a window and implements ActionListener to handle button click events
public class Calculator extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField display; // Text field to display the calculator input and result
    private JPanel panel; // Panel to hold the buttons
    private String[] buttons = { // Array of button labels
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "%", "", "", "DEL"
    };
    private String operand1 = ""; // First operand
    private String operand2 = ""; // Second operand
    private String operator = ""; // Operator

    // Constructor to set up the calculator UI
    public Calculator() {
        display = new JTextField(); // Initialize the display
        display.setEditable(false); // Make the display non-editable by the user
        display.setHorizontalAlignment(JTextField.LEFT); // Align text to the left
        display.setFont(new Font("Courier New", Font.BOLD, 30)); // Set font style and size for the display

        panel = new JPanel(); // Initialize the panel
        panel.setLayout(new GridLayout(5, 4, 10, 10)); // Set a grid layout with 5 rows and 4 columns, and 10px gaps

        // Create buttons, set their font, add action listeners, and add them to the panel
        for (String buttonText : buttons) {
            JButton button = new JButton(buttonText);
            button.setFont(new Font("Courier New", Font.BOLD, 20)); // Set font style and size for buttons
            button.addActionListener(this); // Add action listener to handle button clicks
            panel.add(button); // Add button to the panel
        }

        // Add the display at the top of the frame
        add(display, BorderLayout.NORTH);
        // Add the panel containing buttons to the center of the frame
        add(panel);

        setTitle("Calculator"); // Set the title of the window
        setSize(400, 500); // Set the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true); // Make the window visible
    }

    // Method to handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Get the label of the clicked button

        // If the button is a digit or a decimal point, add it to the current operand
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            if (!operator.isEmpty()) { // If an operator has been set, update the second operand
                operand2 += command;
            } else { // Otherwise, update the first operand
                operand1 += command;
            }
            display.setText(operand1 + operator + operand2); // Update the display
        } else if (command.equals("=")) { // If the "=" button is clicked, calculate the result
            double result = 0;
            // Perform the appropriate calculation based on the operator
            switch (operator) {
                case "+":
                    result = Double.parseDouble(operand1) + Double.parseDouble(operand2);
                    break;
                case "-":
                    result = Double.parseDouble(operand1) - Double.parseDouble(operand2);
                    break;
                case "*":
                    result = Double.parseDouble(operand1) * Double.parseDouble(operand2);
                    break;
                case "/":
                    result = Double.parseDouble(operand1) / Double.parseDouble(operand2);
                    break;
                case "%":
                    result = Double.parseDouble(operand1) % Double.parseDouble(operand2);
                    break;
            }
            // Update the display with the result and reset operands and operator
            display.setText(operand1 + " " + operator + " " + operand2 + " = " + result);
            operand1 = Double.toString(result);
            operand2 = "";
            operator = "";
        } else if (command.equals("DEL")) { // If the "DEL" button is clicked, delete the last character
            if (!operand2.isEmpty()) { // If the second operand is not empty, delete from it
                operand2 = operand2.substring(0, operand2.length() - 1);
            } else if (!operator.isEmpty()) { // If the operator is set, clear it
                operator = "";
            } else if (!operand1.isEmpty()) { // If the first operand is not empty, delete from it
                operand1 = operand1.substring(0, operand1.length() - 1);
            }
            display.setText(operand1 + operator + operand2); // Update the display
        } else { // If any operator button is clicked, set the operator
            if (operator.isEmpty() || operand2.isEmpty()) {
                operator = command;
            } else { // If there is an existing operator and second operand, calculate the result first
                double result = 0;
                switch (operator) {
                    case "+":
                        result = Double.parseDouble(operand1) + Double.parseDouble(operand2);
                        break;
                    case "-":
                        result = Double.parseDouble(operand1) - Double.parseDouble(operand2);
                        break;
                    case "*":
                        result = Double.parseDouble(operand1) * Double.parseDouble(operand2);
                        break;
                    case "/":
                        result = Double.parseDouble(operand1) / Double.parseDouble(operand2);
                        break;
                    case "%":
                        result = Double.parseDouble(operand1) % Double.parseDouble(operand2);
                        break;
                }
                operand1 = Double.toString(result); // Update the first operand with the result
                operator = command; // Set the new operator
                operand2 = ""; // Clear the second operand
            }
            display.setText(operand1 + operator); // Update the display
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator()); // Create and show the calculator window
    }
}
