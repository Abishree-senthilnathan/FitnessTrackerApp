import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FitnessTrackerApp extends JFrame {
    private JTextField stepsField;
    private JTextField distanceField;
    private JTextField weightField;
    private JTextField heightField;
    private JButton trackButton;
    private JLabel resultLabel;
    
    public FitnessTrackerApp() {
        setTitle("Health and Fitness Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null); // Center the window

        // Create input fields
        stepsField = new JTextField(10);
        distanceField = new JTextField(10);
        weightField = new JTextField(10);
        heightField = new JTextField(10);
        trackButton = new JButton("Track Activity");

        // Style input fields and button
        stepsField.setFont(new Font("Arial", Font.PLAIN, 14));
        distanceField.setFont(new Font("Arial", Font.PLAIN, 14));
        weightField.setFont(new Font("Arial", Font.PLAIN, 14));
        heightField.setFont(new Font("Arial", Font.PLAIN, 14));
        trackButton.setFont(new Font("Arial", Font.BOLD, 14));
        trackButton.setBackground(new Color(30, 144, 255));
        trackButton.setForeground(Color.WHITE);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setOpaque(true); // Make the label background visible
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        resultLabel.setPreferredSize(new Dimension(400, 100));
        resultLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Action listener for the track button
        trackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int steps = Integer.parseInt(stepsField.getText());
                    double distance = Double.parseDouble(distanceField.getText());
                    double weight = Double.parseDouble(weightField.getText());
                    double height = Double.parseDouble(heightField.getText());

                    // Perform calculations to estimate calories burned
                    double caloriesBurned = calculateCaloriesBurned(steps, distance);

                    // Calculate BMI
                    double bmi = calculateBMI(weight, height);

                    // Get daily calorie intake suggestion
                    String calorieIntakeSuggestion = getCalorieIntakeSuggestion(bmi);

                    // Calculate health score
                    int healthScore = calculateHealthScore(bmi);

                    // Set color based on health score
                    Color scoreColor = getScoreColor(healthScore);

                    // Display the results to the user
                    resultLabel.setText("<html>Calories Burned: " + caloriesBurned + "<br/>BMI: " + String.format("%.2f", bmi) +
                            "<br/>" + calorieIntakeSuggestion + "<br/>Health Score: " + healthScore + "/10</html>");
                    resultLabel.setBackground(scoreColor);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers.");
                    resultLabel.setBackground(Color.RED);
                }
            }
        });

        // Input panel with a better layout
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Steps taken:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(stepsField, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Distance (km):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(distanceField, gbc);
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Weight (kg):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(weightField, gbc);
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Height (m):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(heightField, gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        inputPanel.add(trackButton, gbc);

        // Result panel
        JPanel resultPanel = new JPanel();
        resultPanel.add(resultLabel);

        // Main layout
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        // Add padding around the main content
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // Method to calculate estimated calories burned
    private double calculateCaloriesBurned(int steps, double distance) {
        // Simplified calculation; you can implement a more accurate formula
        double caloriesPerStep = 0.04; // Sample value, modify accordingly
        double caloriesPerDistance = 0.1; // Sample value, modify accordingly

        return (steps * caloriesPerStep) + (distance * caloriesPerDistance);
    }

    // Method to calculate BMI
    private double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    // Method to get daily calorie intake suggestion based on BMI
    private String getCalorieIntakeSuggestion(double bmi) {
        if (bmi < 18.5) {
            return "You are underweight. You should increase your calorie intake.";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "You have a normal weight. Maintain your current calorie intake.";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "You are overweight. Consider reducing your calorie intake.";
        } else {
            return "You are obese. It's recommended to significantly reduce your calorie intake.";
        }
    }

    // Method to calculate health score based on BMI
    private int calculateHealthScore(double bmi) {
        if (bmi < 18.5) {
            return 4;
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return 10;
        } else if (bmi >= 25 && bmi < 29.9) {
            return 6;
        } else {
            return 2;
        }
    }

    // Method to get color based on health score
    private Color getScoreColor(int healthScore) {
        switch (healthScore) {
            case 10:
                return new Color(144, 238, 144); // Light green
            case 6:
                return new Color(255, 255, 102); // Light yellow
            case 4:
                return new Color(255, 165, 0); // Orange
            case 2:
                return new Color(255, 69, 0); // Red
            default:
                return Color.WHITE;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FitnessTrackerApp().setVisible(true);
            }
        });
    }
}
