package tutorialW12;

import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Scanner;

public class Marks {
    private static double QUIT_CODE  = -1;
    public static void main(String[] args) {
        double[] marks = new double[0];
        boolean quit = false;
        do {
            marks = Arrays.copyOf(marks, marks.length+1);
            double newMark = getDouble("Enter a student percentage");
            if(newMark==QUIT_CODE){
                quit = true;
            } else {
                marks[marks.length-1] = newMark;
                JOptionPane.showMessageDialog(null, countFirstClassHonours(marks)+" students obtained first class honours. The highest mark was "+determineBestMark(marks)+"%.");
            }

        } while(!quit);
    }
    private static double determineBestMark(double[] marks){
        double bestMark = 0;
        for(double mark: marks){
            if(mark>bestMark){
                bestMark = mark;
            }
        }
        return bestMark;
    }
    private static int countFirstClassHonours(double[] marks){
        int firstClassCount = 0;
        for (double mark : marks) {
            if (mark>70){
                firstClassCount++;
            }
        }
        return firstClassCount;
    }
    private static double getDouble(String message){
        String inputBox = JOptionPane.showInputDialog(message);
        Scanner inputParse = new Scanner(inputBox);
        if(inputParse.hasNextDouble()){
            return inputParse.nextDouble();
        } else if (inputParse.hasNext("quit")){
            return -1;
        }
        else {
            return getDouble(message);
        }
    }
}
