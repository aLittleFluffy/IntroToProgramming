import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class HiLow {
    private static int MAX_NUM=12;
    private static int MIN_NUM=0;
    private static String[] cards = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

    public static void main(String[] args) {
        int winCount = 0;
        int lastCard = cardSelection();

        do {
            String input = JOptionPane.showInputDialog("The card is a "+ cards[lastCard] + "\nDo you think the next card will be higher, lower, or equal?");
            int newCard = cardSelection();
            Scanner response = new Scanner( input );

            if(response.hasNext()){
                if(response.hasNext("higher")){
                    if(newCard>lastCard){
                        winCount++;
                    } else {
                        winCount=0;
                    }
                } else if(response.hasNext("lower")){
                    if(newCard<lastCard){
                        winCount++;
                    } else {
                        winCount=0;
                    }
                } else if(response.hasNext("equal")){
                    if(newCard==lastCard){
                        winCount++;
                    } else {
                        winCount=0;
                    }
                }
            }

            lastCard = newCard;
            System.out.println(winCount);

        } while(winCount<=4);
        JOptionPane.showMessageDialog(null, "The card was a " + cards[cardSelection()] +"\nCongratulations you won.");
    }
    private static int cardSelection(){
        Random generator = new Random();
        return generator.nextInt((MAX_NUM - MIN_NUM ) + 1) + MIN_NUM;
    }
}
