package tutorialW10;

import javax.swing.*;
import java.util.Scanner;

public class Factorian {
    public static void main(String[] args) {
        boolean quit = false;
        try{
            do {
                String inputBlock = JOptionPane.showInputDialog("What factorian would you like to find? ");
                Scanner inputParser = new Scanner( inputBlock );
                if(inputParser.hasNextInt()){
                    int numberToCompute = inputParser.nextInt();
                    if(isFactorian(numberToCompute)){
                        JOptionPane.showMessageDialog(null, numberToCompute+ " is a Factorian");
                    }
                } else if(inputParser.hasNext("quit")) {
                    quit = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid input.");
                }
            } while(!quit);
        } catch(Exception e){
            System.out.println(e);
        }


    }
    public static int computeFactorial(int number){
        if(number>1){
            return number* computeFactorial(number-1);
        } else {
            return 1;
        }
    }
    public static boolean isFactorian(int original){
        int number = original;
        int[] factorials = new int [String.valueOf(number).length()];
        int sum = 0;
        for(int count = 0; count<factorials.length; count++){
            int toCompute = number%10;
            factorials[count] = computeFactorial(toCompute);
            sum += computeFactorial(toCompute);
            number = number/10;
        }
        return (original==sum);
    }
}
