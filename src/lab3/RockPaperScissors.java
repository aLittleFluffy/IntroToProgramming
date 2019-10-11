package lab3;

/* SELF ASSESSMENT
   1. Did I use appropriate easy-to-understand, meaningful variables and CONSTANTS within the code?
       Mark out of 10: 10
       Comment: All variables and Constants describe what is saved in the given variable
   2. Did I format the variable and CONSTANT names appropriate (in lowerCamelCase and UPPERCASE)?
       Mark out of 5: 5
       Comment: All variables and constants are formatted correctly
   3. Did I generate the computer's choice in each game correctly using a Random number generator?
       Mark out of 10: 10
       Comment: Computer selection method uses Random to generate a random number between 1 and 3 (inclusive)
   4. Did I input the user's choice in each game correctly?
       Mark out of 10: 10
       Comment:Program clearly asks user to input integers for selection
   5. Did I correctly compare the choices and update the score appropriately?
       Mark out of 20: 20
       Comment: All possible combinations are addressed and handled.
   6. Did I inform the user of who won each game (and why) correctly?
       Mark out of 10: 10
       Comment: Each handled response includes a message dialog box which informs the user of the game outcome.
   7. Did I use an appropriate for loop to allow the player to play 5 games?  There should be only one loop.
       Mark out of 20: 20
       Comment: A for loop is properly used to iterate through the same loop 5 times with score counting variables outside the loop.
   8. Did I output the final scores correctly after the 5 games were played.
       Mark out of 10: 10
       Comment: Yes, a message box is used to show the result of the 5 round game
   9. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: All marks and comments are filled out
   Total Mark out of 100 (Add all the previous marks): 10
*/

import javax.swing.*;
import java.util.Random;

public class RockPaperScissors {
    public final static int MAX_NUM = 3;
    public final static int MIN_NUM = 1;
    public static void main(String[] args){
        int computerScore = 0;
        int userScore = 0;

        for(int counter = 0; counter<5; counter++){
            int computerSelectionNum = computerSelection();
            String computerSelectionString = "";
            if(computerSelectionNum == 1){
                computerSelectionString = "Rock";
            } else if(computerSelectionNum ==2){
                computerSelectionString = "Paper";
            } else if(computerSelectionNum == 3){
                computerSelectionString = "Scissors";
            }

            int usrSelectionNum = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter 1 (for Rock), 2 (for Paper), or 3 (for Scissors)"));
            if((usrSelectionNum!=1)&&(usrSelectionNum!=2)&&(usrSelectionNum!=3)){
                JOptionPane.showMessageDialog(null,"You have entered an impossible value, therfore you lose");
                computerScore++;
            } else if(usrSelectionNum == computerSelectionNum){
                JOptionPane.showMessageDialog(null, "The round was a draw as I selected " +
                        computerSelectionString +" as well.");
            } else if((usrSelectionNum == 1)&&(computerSelectionNum== 3)){
                JOptionPane.showMessageDialog(null, "You win this round as I selected "+
                        computerSelectionString);
                userScore++;
            } else if((usrSelectionNum==2)&&(computerSelectionNum==1)){
                JOptionPane.showMessageDialog(null, "You win this round as I selected "+
                        computerSelectionString);
                userScore++;
            } else if((usrSelectionNum==3)&&(computerSelectionNum==2)){
                JOptionPane.showMessageDialog(null, "You win this round as I selected " +
                        computerSelectionString);
                userScore++;
            } else if((computerSelectionNum==1)&&(usrSelectionNum==3)){
                JOptionPane.showMessageDialog(null, "I win this round as I selected " +
                        computerSelectionString);
                computerScore++;
            } else if((computerSelectionNum==2)&&(usrSelectionNum==1)){
                JOptionPane.showMessageDialog(null, "I win this round as I selected "+
                        computerSelectionString);
                computerScore++;
            } else if((computerSelectionNum==3)&&(usrSelectionNum==2)){
                JOptionPane.showMessageDialog(null, "I win this round as I selected "+
                        computerSelectionString);
                computerScore++;
            }
        }
        JOptionPane.showMessageDialog(null, "The final score was Computer: "+computerScore
                +" User: "+userScore);
    }
    public static int computerSelection(){
        Random generator = new Random();
        return generator.nextInt((MAX_NUM - MIN_NUM) +1) + MIN_NUM;
    }
}
