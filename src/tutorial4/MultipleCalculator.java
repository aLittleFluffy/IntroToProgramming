package tutorial4;

import javax.security.auth.callback.TextInputCallback;
import javax.swing.*;

public class MultipleCalculator {
    public static void main(String[] args){
        JPanel inputs = new JPanel();
        inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));

        JTextField baseInput = new JTextField();
        JTextField maxInput = new JTextField();

        JLabel baseLabel = new JLabel("What would you like to find the multiples of");
        JLabel maxLabel = new JLabel("What would you find the multiples to");

        inputs.add(baseLabel);
        inputs.add(baseInput);
        inputs.add(maxLabel);
        inputs.add(maxInput);



        try {
            JOptionPane.showConfirmDialog(null, inputs, "Enter Data", JOptionPane.YES_NO_OPTION);
            int base = Integer.parseInt(baseInput.getText());
            int max = Integer.parseInt(maxInput.getText());
            String responseText = "The multiples of " + base + " (up to "+max+") are ";

            if (base < 0) {
                JOptionPane.showMessageDialog(null, "Please Enter positive base");
            } else if(max<0){
                JOptionPane.showMessageDialog(null, "Please Enter Positive max");
            } else {
                for(int i =0; i<=max; i++){
                    if(i%base==0){
                        responseText = responseText + i +", ";
                    }
                }
            }
            responseText = responseText.substring(0, responseText.length()-2);

            JOptionPane.showMessageDialog(null, responseText);
            main(new String[0]);
        } catch(NumberFormatException e) {
            System.out.println("User exited window");
            System.exit(0);
        }
    }
}
