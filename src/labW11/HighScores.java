package labW11;

import javax.swing.*;
import java.util.Scanner;

public class HighScores {
    public static void main(String[] args) {
        boolean quit = false;
        do{
            int count = 0;
            int numOfScores = getInt("How many highscores would you like to save?");
            int[] highScores = initializeHighScores(numOfScores);
            do{

            }while((count<highScores.length) && !quit);

        } while(!quit);
    }
    private static int[] initializeHighScores(int numberOfHighScores){
        return new int[numberOfHighScores];
    }
    private static void printHighScores(int[] highScores){
        String response = "The high scores are ";
        for (int highScore : highScores) {
            response = response + highScore + " ";
        }
        JOptionPane.showMessageDialog(null, response);
    }
    private static int higherThan(int[] highScores, int newVal){
        for (int i = 0; i < highScores.length; i++) {
            if(newVal>highScores[i]){
                return i;
            }
        }
        return 0;
    }
    private static int[] insertScore(int[] highScores, int newVal){
        int replacementIndex = higherThan(highScores, newVal);
        int[] returnArr = new int[highScores.length];
        for (int i = highScores.length-1; i > replacementIndex; i--) {
            returnArr[i] = highScores[i-1];
        }
        returnArr[replacementIndex] = newVal;
        for (int i = 0; i < replacementIndex; i++) {
            returnArr[i] = highScores[i];
        }
        return returnArr;
    }

    private static int getInt(String message){
        String input = JOptionPane.showInputDialog(message);
        Scanner inputParser = new Scanner(input);
        if(inputParser.hasNextInt()){
            return inputParser.nextInt();
        } else {
            return getInt(message);
        }
    }
}
