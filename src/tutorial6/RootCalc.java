package tutorial6;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Float.NaN;

public class RootCalc {
    final static String UNACCEPTED_ANSWER = "Your input was not accepted, try again";
    public static void main(String[] args) {
        boolean quit = false;
        do{
            try {
                String inputBox = JOptionPane.showInputDialog("Enter the coefficients of your second order polynomial seperated by spaces (or enter quit): ");
                Scanner inputParser = new Scanner(inputBox);
                // TODO: HANDLE QUIT
                if(inputParser.hasNextDouble()){
                    double secondDegree = inputParser.nextDouble();
                    double firstDegree = inputParser.nextDouble();
                    double constant = inputParser.nextDouble();
                    System.out.println(secondDegree+" "+firstDegree+" "+constant);

                    double[] roots = calculation(secondDegree, firstDegree, constant);
                    if((Math.pow(firstDegree,2)-(4*secondDegree*constant))<0){
                        JOptionPane.showMessageDialog(null, "There are no real roots");
                    }
                    else if(!Double.isNaN(roots[0]) && !Double.isNaN(roots[1])){
                        JOptionPane.showMessageDialog(null, "The roots to this equation are x="+roots[0]+" and x="+roots[1]);
                    } else if(!Double.isNaN(roots[0])){
                        JOptionPane.showMessageDialog(null, "This equation has one root at x="+roots[0]);
                    } else if(!Double.isNaN(roots[1])){
                        JOptionPane.showMessageDialog(null, "This equation has one root at x="+roots[1]);
                    } else if(Double.isNaN(roots[0]) && Double.isNaN(roots[1])){
                        JOptionPane.showMessageDialog(null, "This equation has no real roots");
                    } else {
                        JOptionPane.showMessageDialog(null, "An unknown error occurred, Try again");
                    }

                } else if(inputParser.hasNext("quit")) {
                    System.out.println("Quit written, exiting...");
                    quit = true;
                } else {
                    JOptionPane.showMessageDialog(null,UNACCEPTED_ANSWER);
                }
            } catch (NullPointerException e){
                quit=true;
            } catch(InputMismatchException e){
                JOptionPane.showMessageDialog(null, UNACCEPTED_ANSWER);
            }

        } while(!quit);
        System.exit(0);
    }
    static double[] calculation(double secondDegree, double firstDegree, double constant){
       // try {
            double[] calculatedRoots = new double[2];
            double sqrtStuff = Math.sqrt((Math.pow(firstDegree,2)-(4*secondDegree*constant)));
            calculatedRoots[0] = (((-1)*firstDegree)+sqrtStuff)/(2*secondDegree);
            System.out.println(calculatedRoots[0]);
            calculatedRoots[1] = (((-1)*firstDegree)-sqrtStuff)/(2*secondDegree);
            return calculatedRoots;
        //} catch()


    }
}
