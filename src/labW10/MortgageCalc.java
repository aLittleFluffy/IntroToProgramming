package labW10;

import javax.swing.*;
import java.util.Scanner;

public class MortgageCalc {
    final static int MONTHS_IN_YEAR = 12;
    final static int MORTGAGE_LENGTH_YRS = 20;
    final static int DIVISOR_FOR_APR_TO_DECIMAL = 100;

    public static void main(String[] args) {
        boolean quit = false;
        do{
            JOptionPane.showMessageDialog(null, "Welcome to Mortgage Calculator");
            double mortgageAmount = readDoubleFromUser("Please Enter Mortgage Amount: ");
            double apr = readDoubleFromUser("Please enter annual interest rate (APR): ");
            JOptionPane.showMessageDialog(null, "Assuming a 20 year term, the monthly repayments would be "+ String.format("%.2f", calculateMonthlyRepayment(mortgageAmount, MORTGAGE_LENGTH_YRS, apr)));
            double monthlyRepaymentAmount = readDoubleFromUser("How much can you afford to pay per month?");
            int repaymentLengthMonths = calculateMonthsToRepay(mortgageAmount, monthlyRepaymentAmount, apr);
            JOptionPane.showMessageDialog(null, "If you pay "+monthlyRepaymentAmount+" per month, your mortgage would be paid off in "+ repaymentLengthMonths/12 +" years and and " + repaymentLengthMonths%12 +" months." );
            String quitResponse = JOptionPane.showInputDialog("Would you like to use the mortgage calculator again? (yes or no)");
            Scanner quitResponseParser = new Scanner(quitResponse);
            if(quitResponseParser.hasNext("no")){
                quit=true;
            }
        } while(!quit);
        System.exit(0);
    }

    static double readDoubleFromUser(String message){
        String inputBlock = JOptionPane.showInputDialog(message);
        Scanner inputParser = new Scanner(inputBlock);
        if(inputParser.hasNextDouble()){
            return inputParser.nextDouble();
        } else{
            return readDoubleFromUser(message);
        }
    }

    static double calculateMonthlyRepayment(double principal, int years, double apr){
        double monthlyRepaymentAmount = principal * (apr/MONTHS_IN_YEAR/DIVISOR_FOR_APR_TO_DECIMAL) / (1-Math.pow((1+apr/MONTHS_IN_YEAR/DIVISOR_FOR_APR_TO_DECIMAL),((-1)*years)*12));
        return monthlyRepaymentAmount;
    }

    static int calculateMonthsToRepay(double mortgageAmount, double monthlyRepayment, double apr){
        if (mortgageAmount > 0) {
            double newMortgageAmount = mortgageAmount+((mortgageAmount*(apr/MONTHS_IN_YEAR/DIVISOR_FOR_APR_TO_DECIMAL))-monthlyRepayment);
            return 1 + calculateMonthsToRepay( newMortgageAmount, monthlyRepayment, apr);
        } else {
            return 0;
        }
    }

}
