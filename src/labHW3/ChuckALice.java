package labHW3;

import javax.swing.*;
import java.util.Scanner;

public class ChuckALice {
    private static String[] BET_TYPES = {"Low", "High", "Triple","Field"};
    public static void main(String[] args) {
        Wallet playerWallet = new Wallet();
        double initWallet = getDouble("How much money would you like in your wallet to begin?");
        playerWallet.put(initWallet);
        boolean quit = false;
        do {
            int bet = getBetType();
            if(bet==0){
                quit = true;
            } else {
                resolveBet(BET_TYPES[bet-1], playerWallet);
            }
        } while(!quit && playerWallet.check()>0);
        JOptionPane.showMessageDialog(null, "Game Over! You started with €"+initWallet+", you now have €"+playerWallet.check());
    }
    public static void resolveBet(String betType, Wallet playerWallet){
        double walletAmount = playerWallet.check();
        double betAmount = getDouble("You have €" +playerWallet.check()+" in your wallet right now. How much would you like to bet: ");
        while(betAmount>walletAmount){
            betAmount = getDouble("You have €" +playerWallet.check()+" in your wallet right now. How much would you like to bet, remember you cannot bet more than €"+playerWallet.check()+": ");
        }
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();

        d1.roll();
        d2.roll();
        d3.roll();

        if(betType =="Triple"){
            if(d1.topFace()==d2.topFace() && d2.topFace()==d3.topFace()){
                if(d1.topFace()==3 || d1.topFace()== 6){
                    // lost logic

                } else {
                    // win logic
                }
            }
        } else if(betType=="Low"){
            if(d1.topFace()+d2.topFace()+d3.topFace()<11&& !(d1.topFace()==d2.topFace() && d2.topFace()==d3.topFace())){
                // win logic
            } else {
                // loss logic
            }
        } else if(betType == "High"){
            if(d1.topFace()+d2.topFace()+d3.topFace()>10&& !(d1.topFace()==d2.topFace() && d2.topFace()==d3.topFace())){
                // win logic
            } else {
                // loss logic
            }
        } else if (betType == "Field") {
            if(d1.topFace()+d2.topFace()+d3.topFace()<8 || d1.topFace()+d2.topFace()+d3.topFace()>12){
                // win logic
            } else {
                // loss logic
            }
        }

    }
    public static int getBetType(){
        String input = JOptionPane.showInputDialog("Which bet would you like to place? (1 for low, 2 for high, 3 for triple, 4 for field, or type 'quit' to quit):");
        Scanner inputParser = new Scanner(input);
        try {
            if(inputParser.hasNextInt()){
                int nextNum = inputParser.nextInt();
                if (nextNum >=1 && nextNum <=4) {
                    return nextNum;
                } else{
                    return getBetType();
                }
            } else if(inputParser.hasNext("quit")){
                return 0;
            } else {
                return getBetType();
            }
        } catch (Exception e){
            return getBetType();
        }
    }
    public static double getDouble(String message){
        String input = JOptionPane.showInputDialog(message);
        Scanner inputParser = new Scanner(input);
        try {
            if(inputParser.hasNextDouble()){
                double nextNum = inputParser.nextDouble();
                if (nextNum > 0) {
                    return nextNum;
                } else{
                    return getDouble(message);
                }
            } else {
                return getDouble(message);
            }
        } catch (Exception e){
            return getDouble(message);
        }

    }
}
