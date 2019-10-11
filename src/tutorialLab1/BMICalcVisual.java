// Tutorial Goal
// Calculate BMI Value

package tutorialLab1;
import javax.swing.*;

class BMICalcVisual {
    public static void main(String[] args) {
        JPanel inputPanel = new JPanel(); // Initialize actual window
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS)); // Set layout to add new fields/labels along y axis instead of x
        JTextField heightInput = new JTextField(10); // Input field for height
        JTextField weightInput = new JTextField(10); // Input field for weight
        JLabel heightLabel = new JLabel("Enter your Height (meter)"); // Label prompting user for height (to be placed above text field)
        JLabel weightLabel = new JLabel("Enter your weight (kg)"); // Label prompting user for weight
        inputPanel.add(heightLabel); // Placing Height Label in window
        inputPanel.add(heightInput);
        inputPanel.add(weightLabel);
        inputPanel.add(weightInput);

        int response = JOptionPane.showConfirmDialog(null, inputPanel, "Enter the values",
                JOptionPane.OK_CANCEL_OPTION); // Presenting actual pane waits for confirmation before continuing

        if (response == JOptionPane.OK_OPTION) {
            // TODO: clean and check entries before below steps
            double height = Double.parseDouble(heightInput.getText()); // collecting entered height
            double weight = Double.parseDouble(weightInput.getText()); // Collecting entered weight
            JOptionPane.showMessageDialog(null, "Your BMI is " + bmiCalc(height, weight)); // Final window showing calculated BMI using bmiCalc method to do computation
        }
        if (response == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No input was entered and cancel was hit");
        } else {
            JOptionPane.showMessageDialog(null, "A different error occurred");
        }

    }

    private static double bmiCalc(double height, double weight) {
        double calculation = (weight / (height * height));
        calculation = (double) Math.round(calculation * 100d) / 100d; // Using math class to round to nearest 100th
        return calculation;
    }
}