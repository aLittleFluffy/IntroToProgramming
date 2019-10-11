package tutorial5;

import javax.swing.*;
import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
    	boolean functional=true;
        do {
        	try{
                String input = JOptionPane.showInputDialog("Enter your numbers separated by a single space");

                int minNum = Integer.MAX_VALUE;
                int maxNum = 0;

                if(input.length()==0){
                    System.out.println("Empty Input");
                }
                if(input.length() != 0){
                    Scanner usrResponse = new Scanner(input);
                    while(usrResponse.hasNext()){
                        int currentNum = usrResponse.nextInt();
                        if(currentNum < minNum){
                            minNum = currentNum;
                        } else if(currentNum > maxNum){
                            maxNum = currentNum;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Your minimum number is "+minNum+"\nYour maximum number is "+maxNum);
                }
            } catch (NullPointerException e){
                //System.out.println(e);
                System.exit(0);
            }
        } while(functional);
        main(new String[0]);
    }
}
