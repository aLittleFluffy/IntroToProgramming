package lab2;

/* SELF ASSESSMENT
   1. Did I use easy-to-understand meaningful variable and CONSTANT names?
       Mark out of 10: 10
       Comment: All variables and constants are meaningful and tell a reader what the variable is used for
   2. Did I format the variable and CONSTANT names properly (in lowerCamelCase and UPPERCASE_WITH_UNDERSCORES)?
       Mark out of 10: 10
       Comment: All variables are in lower camelcase and constants are in all capital letters with underscores for spaces
   3. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: Code was automatically formatted by IDE
   4. Did I read the input correctly from the user using appropriate questions?
       Mark out of 15: 15
       Comment: Questions match those outlined in the Lab brief. Input is then read and parsed in the correct datatype from input fields.
   5. Did I compute the disposable income and disposable income percentage correctly, and output it in the correct format?
       Mark out of 15: 15
       Comment: Computations are consistently successful and correct
  6. Did I use an appropriate series of if statements to generate the income analysis to the user?
       Mark out of 25: 25
       Comment: The correct answers are generated after going through a series of if statements.
   7. Did I provide the correct output for each possibility in an easy to read format?
       Mark out of 10: 10
       Comment: Output is placed in a JOptionPane Message dialog box making it easy and straightforward to read.
   8. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: All marks and comments made. All relevant criteria met in code.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import javax.swing.*;

public class WagesAnalyze {
    public static final double TAX_RATE = 0.35;
    public static final double AVG_DISPOSABLE_INCOME = 500;
    public static final double SIGNIFICANT_PROPORTION = 0.5;

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

        int response = JOptionPane.showConfirmDialog(null, dataInput, "Enter all your inputs",
                JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            double income = Double.parseDouble(incomeInput.getText());
            double rent = Double.parseDouble(rentInput.getText());
            double commute = Double.parseDouble(commuteInput.getText());
            double food = Double.parseDouble(foodSpendInput.getText());
            double disposable = getDisposableIncome(income, rent, commute, food);
            double percentageOfIncome = (disposable / income) * 100;

            if (disposable == 0) {
                JOptionPane.showMessageDialog(null, "You do not have any disposable income");
            } else {
                if (disposable > ((1+ SIGNIFICANT_PROPORTION) * AVG_DISPOSABLE_INCOME)) {
                    JOptionPane.showMessageDialog(null, "Your disposable income is €" +
                            disposable + " which is " + (int) Math.round(percentageOfIncome) +
                                "% of your monthly income\nThis is much more than average disposable income");
                }
                if (disposable < ((1+ SIGNIFICANT_PROPORTION) * AVG_DISPOSABLE_INCOME) && (disposable > AVG_DISPOSABLE_INCOME)) {
                    JOptionPane.showMessageDialog(null, "Your disposable income is €" +
                            disposable + " which is " + (int) Math.round(percentageOfIncome) +
                                "% of your monthly income" + "\nThis is more than average disposable income");
                }
                if (disposable == AVG_DISPOSABLE_INCOME) {
                    JOptionPane.showMessageDialog(null, "Your disposable income is €" +
                            disposable + " which is " + (int) Math.round(percentageOfIncome) +
                                "% of your monthly income" + "\nThis is the average disposable income");
                }
                if ((disposable <AVG_DISPOSABLE_INCOME)&&(disposable > ((SIGNIFICANT_PROPORTION)*AVG_DISPOSABLE_INCOME))) {
                    JOptionPane.showMessageDialog(null, "Your disposable income is €" +
                            disposable + " which is " + (int) Math.round(percentageOfIncome) +
                                "% of your monthly income" + "\nThis is less than average disposable income");
                }
                if (disposable < (SIGNIFICANT_PROPORTION) * AVG_DISPOSABLE_INCOME) {
                    JOptionPane.showMessageDialog(null, "Your disposable income is €" +
                            disposable + " which is " + (int) Math.round(percentageOfIncome) +
                                "% of your monthly income\nThis is much less than the average disposable income");
                }
            }
        }
        if (response == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "There was an error in completing the calculation");
        }
    }

    public static double getDisposableIncome(double income, double rent, double commute, double food) {
        double afterTax = income - (income * TAX_RATE);
        double disposableIncome = afterTax - rent - commute - food;
        return disposableIncome;
    }
}
