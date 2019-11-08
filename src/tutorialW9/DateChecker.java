package tutorialW9;

import javax.swing.*;
import java.util.Scanner;

public class DateChecker {
    public static void main(String[] args) {
        boolean quit = false;
        try{
            do {
                String inputMessage = JOptionPane.showInputDialog("Enter date with format dd/mm/yyyy, or type quit to quit");
                Scanner input = new Scanner(inputMessage);
                input.useDelimiter("/");
                //int month = 0;
                //int year = 0;
                //int day = 0;
                int month, year, day = 0;
                
                if (input.hasNextInt()){
                    day = input.nextInt();
                    month = input.nextInt();
                    year = input.nextInt();
                    boolean isValidDate = validDate(year, month, day);
                    if(isValidDate){
                        JOptionPane.showMessageDialog(null, "This is a valid date");
                    } else {
                        JOptionPane.showMessageDialog(null, "Try again, this is not a valid date");
                    }
                }

                if(input.hasNext("quit")){
                    quit = true;
                }

            } while (!quit);
        } catch (Exception e){
            System.out.println("Error occurred");
        }


    }
    static boolean validDate(int year, int month, int day){
        if(year<0){
            return false;
        } else if(month<1 || month>12){
            return false;
        } else if(day>daysInMonth(month, year)){
            return false;
        } else if(day>31 && day<1){
            return false;
        } else{
            return true;
        }
    }

    static int daysInMonth(int month, int year){
        switch(month){
            case 2:
                if(isLeapYear(year)){
                    return 29;
                } else {
                    return 28;
                }
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
    static boolean isLeapYear(int year){
        if (year%400==0){
            return true;
        } else if((year%4==0) && (year%100!=0)){
            return true;
        } else {
            return false;
        }
    }
}
