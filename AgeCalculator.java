import javax.swing.*;
import java.awt.*;

// Class to create a GUI for the program.
public class AgeCalculator extends JFrame {
    final private Font mainFont = new Font("Verdana", Font.PLAIN, 16);
    JTextField dateOfBirth;
    JLabel ageResult;
    // Constructs GUI for the Age Calculator application
    public void run() {
        JLabel introLabel = new JLabel("Enter date of birth (YYYY-MM-DD) and click OK to calculate age. ");
        introLabel.setFont(mainFont);

        JLabel enterDateLabel = new JLabel("Enter date of birth: ");
        enterDateLabel.setFont(mainFont);
        
        dateOfBirth = new JTextField();
        dateOfBirth.setFont(mainFont);

        // Input label and text field for user to enter date of birth
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1, 5, 5));
        inputPanel.setOpaque(false); // Set panel to be transparent 
        inputPanel.add(enterDateLabel);
        inputPanel.add(dateOfBirth);

        // Result label to display the calculated age
        ageResult = new JLabel();
        ageResult.setFont(mainFont);

        // OK button to trigger age calculation
        JButton okButton = new JButton("OK");
        okButton.setFont(mainFont);
        okButton.addActionListener(e -> {

            String dob = dateOfBirth.getText();

            try {
                // Clean and format the input
                dob = Utilities.formatDateOfBirth(dob);
                // Calculate the age
                int age = Operations.calculateAge(dob);

                ageResult.setText("Your age is: " + age + " years.");

            } catch (Exception ex) {
                // Display the exception message
                ageResult.setText("Error: " + ex.getMessage());
            }
        });
        
        // Clear button to reset the input and result fields
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(mainFont);
        clearButton.addActionListener(e -> {
            
            dateOfBirth.setText("");
            ageResult.setText("");
        });

        // Panel to display buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonPanel.setOpaque(false); 
        buttonPanel.add(okButton);
        buttonPanel.add(clearButton);

        // Main panel to hold all components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding around components

        // Adding intoLabel to top of the main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns for the intro label
        gbc.anchor = GridBagConstraints.WEST; // Alight the label left
        mainPanel.add(introLabel, gbc);

        // Adding inputPanel to the main panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(inputPanel, gbc);

        // Adding ageResult label to the main panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH; // Fill the space in both directions
        gbc.weightx = 1.0; // Allow the label to expand horizontally
        gbc.weighty = 1.0; // Allow the label to expand vertically
        mainPanel.add(ageResult, gbc);

        // Adding buttonPanel to the main panel
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        gbc.weighty = 0;
        mainPanel.add(buttonPanel, gbc);

        // Adding the main panel to the JFrame
        add(mainPanel);

        // Setting up the JFrame
        setTitle("Age Calculator");
        setSize(700, 600);
        setMinimumSize(new Dimension(500, 600)); // Set minimum size for the window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Close the application when the window is closed
        setVisible(true); // Make the window visible
    }
    // Main method for program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create an instance of the AgeCalculator class
            AgeCalculator frame = new AgeCalculator();
            frame.run();
        });
    }
}