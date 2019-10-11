package tutorial2;

import javax.swing.*;
import java.util.Scanner;

public class AverageAndStandard {
    public static void main(String[] args){
        String inputPane = JOptionPane.showInputDialog("Enter three Integers (separate with commas)");
        Scanner inputParser = new Scanner( inputPane );
        inputParser.useDelimiter(",");

        int[] inputNumbers = {inputParser.nextInt(), inputParser.nextInt(), inputParser.nextInt()};
        int numSum = sum(inputNumbers);
        double average = (double)(numSum/inputNumbers.length);

        double[] stdDevNumVals = new double[inputNumbers.length];
        for(int i = 0; i<inputNumbers.length; i++){
            stdDevNumVals[i] = (double)(inputNumbers[i]-average)*(inputNumbers[i]-average);
        }
        double stdDev = (double)Math.sqrt(sum(stdDevNumVals)/stdDevNumVals.length);

        JOptionPane.showMessageDialog(null, "Your Average is: "+average+"\nYour Standard Deviation: "+Math.round(stdDev));
        main(new String[]{""});

    }
    public static int sum(int[] inputArr){
        int sum = 0;
        for(int i = 0; i<inputArr.length; i++){
            sum += inputArr[i];
        }
        return sum;
    }
    public static double sum(double[] inputArr){
        int sum = 0;
        for(int i = 0; i<inputArr.length; i++){
            sum += inputArr[i];
        }
        return sum;
    }
}
