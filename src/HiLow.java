/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 5
       Comment: The only time numbers are used in code are to reset the win counter.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 5
       Comment: Constant names are meaningful and are formatted correctly
   3. Did I use easy-to-understand meaningful variable names?
       Mark out of 10: 10
       Comment: All variable names share what they store
   4. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5: 5
       Comment: All variables are properly formatted
   5. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: Code has been auto indented by IDE
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose?
       Mark out of 20: 20
       Comment: While loop continues until certain win count has been hit
   7. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10: 10
       Comment: All types of input are handled properly. In this case, any input that does not match the requested input results in a lost round.
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)?
       Mark out of 10: 10
       Comment: Used a random card generated method to generate new cards randomly
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King?
       Mark out of 10: 10
       Comment: Used an array of strings to display cards.
   10. Did I report whether the user won or lost the game before the program finished?
       Mark out of 10: 10
       Comment: Last window of the normal flow of the program shows if the user won or lost(hit max tries without winning).
   11. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: All comments filled out.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class HiLow {
    private static int MAX_NUM=12;
    private static int MIN_NUM=0;
    private static String[] cards = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private static int WIN_NUM = 4;
    private static int MAX_TRIES = 25;

    public static void main(String[] args) {
        int winCount = 0;
        int tryCount = 0;

        int lastCard = cardSelection();
        try {
            do {
                int newCard = cardSelection();

                String input = JOptionPane.showInputDialog("The card is a " + cards[lastCard] + "\nDo you think the next card will be higher, lower, or equal?\nNote: if you do not type \"higher\", \"lower\", or \"equal\" your response will not be logged correctly.");
                Scanner response = new Scanner(input);

                if (response.hasNext()) {
                    if (response.hasNext("higher")) {
                        if (newCard > lastCard) {
                            winCount++;
                        } else {
                            winCount = 0;
                        }
                    } else if (response.hasNext("lower")) {
                        if (newCard < lastCard) {
                            winCount++;
                        } else {
                            winCount = 0;
                        }
                    } else if (response.hasNext("equal")) {
                        if (newCard == lastCard) {
                            winCount++;
                        } else {
                            winCount = 0;
                        }
                    }
                }

                lastCard = newCard;
                tryCount++;

            } while ((winCount < WIN_NUM)&&(tryCount<MAX_TRIES));
            if(winCount == WIN_NUM){
                JOptionPane.showMessageDialog(null, "The card was a " + cards[lastCard] + "\nCongratulations you won. It took " + tryCount+ " tries.");
            } else {
              JOptionPane.showMessageDialog(null, "The card was a "+ cards[lastCard] + "\nYou lost. You have used " + tryCount+ " tries.");
            }
        } catch (NullPointerException exception){
            JOptionPane.showMessageDialog(null, "You closed the window");
            System.exit(0);
        }
    }
    private static int cardSelection(){
        Random generator = new Random();
        return generator.nextInt((MAX_NUM - MIN_NUM ) + 1) + MIN_NUM;
    }
}
