package tutorialW10;

import javax.swing.*;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        boolean quit = false;
        try{
            do {
                String inputBlock = JOptionPane.showInputDialog("What factorial would you like to find? ");
                Scanner inputParser = new Scanner( inputBlock );
                if(inputParser.hasNextInt()){
                    int inputNum = inputParser.nextInt();
                    JOptionPane.showMessageDialog(null, inputNum+ "! is "+factorial(inputNum));
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
    public static int factorial(int number){
        if(number>1){
            return number*factorial(number-1);
        } else {
            return 1;
        }
    }
}
