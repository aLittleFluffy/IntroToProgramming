package lab2;

/*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10:  10
       Comment: Used TAX_RATE as constant
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:  5
       Comment: TAX_RATE is relatively self-explanatory
   3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:  5
       Comment: All constants (TAX_RATE) are all caps with an underscore instead of space
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  10
       Comment: All variables describe the variables use and the content of the given variable
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10
       Comment: Every variable is lower camelcase to allow other people to understand the words and content of the variable
   6. Did I indent the code appropriately?
       Mark out of 10:  10
       Comment: Automatically formatted
   7. Did I read the input correctly from the user using appropriate question(s)?
       Mark out of 10:  10
       Comment: Used parseDouble from JTextField.getText() from textfields with associated field labels that
       															tell the user what to enter in each input box.
   8. Did I compute the disposable income correctly?
       Mark out of 10: 10
       Comment: Yes, I did the calculation out by hand and verified the output
   9. Did I compute the disposable income percentage correctly?
       Mark out of 10: 10
       Comment: Yes, the calculation was correct and adding rounding allowed it to match the desired output.
   10. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10: 10
       Comment: THe output matched the desired output
   11. How well did I complete this self-assessment?
       Mark out of 10: 10
       Comment: Copied and pasted from blackboard to here and completed each comment.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import javax.swing.*;

public class Wages {
    public static final double TAX_RATE = 0.35;

    public static void main(String[] args) {
        JPanel dataInput = new JPanel();
        dataInput.setLayout(new BoxLayout(dataInput, BoxLayout.Y_AXIS));

        JTextField incomeInput = new JTextField();
        JTextField rentInput = new JTextField();
        JTextField commuteInput = new JTextField();
        JTextField foodSpendInput = new JTextField();

        JLabel incomeLabel = new JLabel("How much are you paid a month before tax?");
        JLabel rentLabel = new JLabel("How much do you pay in rent/mortgage in a month?");
        JLabel commuteLabel = new JLabel("How much does your commute cost?");
        JLabel foodLabel = new JLabel("How much do you spend on food per month?");

        dataInput.add(new JLabel("ENTER EVERY UNIT IN EUROS"));
        dataInput.add(new JLabel("(Format €€.cc)"));
        dataInput.add(new JSeparator());
        dataInput.add(incomeLabel);
        dataInput.add(incomeInput);
        dataInput.add(rentLabel);
        dataInput.add(rentInput);
        dataInput.add(commuteLabel);
        dataInput.add(commuteInput);
        dataInput.add(foodLabel);
        dataInput.add(foodSpendInput);

        int response = JOptionPane.showConfirmDialog(null, dataInput, "Enter all your inputs", JOptionPane.YES_NO_OPTION);
        if(response == JOptionPane.YES_OPTION){
            double income = Double.parseDouble(incomeInput.getText());
            double rent = Double.parseDouble(rentInput.getText());
            double commute = Double.parseDouble(commuteInput.getText());
            double food = Double.parseDouble(foodSpendInput.getText());
            double disposable = getDisposableIncome(income, rent, commute, food);
            double percentageOfIncome = (disposable/income)*100;
            JOptionPane.showMessageDialog(null, "Your disposable income is €" + disposable + " which is "
                    + (int)Math.round(percentageOfIncome) + "% of your monthly income");
        } if(response == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "There was an error in completing the calculation");
        }
    }
    public static double getDisposableIncome(double income, double rent, double commute, double food){
        double afterTax = income-(income*TAX_RATE);
        double disposableIncome = afterTax-rent-commute-food;
        return disposableIncome;
    }
}
