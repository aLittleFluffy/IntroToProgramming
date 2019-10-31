package tutorial7;

import javax.swing.*;
import java.util.Scanner;

public class PrimeSelector {
    private static String OUTPUT_MESSAGE_PREFIX = "Prizes should be given to the competitors who come:";

    public static void main(String[] args) {
        try {
            String competitorInput = JOptionPane.showInputDialog("How many competitors are there?");
            Scanner inputParser = new Scanner(competitorInput);
            String prizeList = "";
            if (inputParser.hasNextInt()) {
                int competitorCount = inputParser.nextInt();
                if (competitorCount > 0) {
                    for (int testedNum = 1; testedNum <= competitorCount; testedNum++) {
                        boolean prime = true;
                        for (int divisor = 2; divisor < testedNum; divisor++) {
                            if ((testedNum % divisor) == 0) {
                                prime = false;
                            }
                        }
                        if (prime) {
                            if (testedNum % 100 >= 10 && testedNum % 100 <= 20) {
                                prizeList = prizeList + " " + testedNum + "th";
                            } else {
                                switch (testedNum % 10) {
                                    case 1:
                                        prizeList = prizeList + " " + testedNum + "st";
                                        break;
                                    case 2:
                                        prizeList = prizeList + " " + testedNum + "nd";
                                        break;
                                    case 3:
                                        prizeList = prizeList + " " + testedNum + "rd";
                                        break;
                                    default:
                                        prizeList = prizeList + " " + testedNum + "th";
                                }
                            }

                        }
                    }
                    JOptionPane.showMessageDialog(null, "<html><body><h4>"+OUTPUT_MESSAGE_PREFIX+"</h4><br><p style='width: 500px;'>"+prizeList+"</p></body></html>");
                    //JOptionPane.showMessageDialog(null, OUTPUT_MESSAGE_PREFIX + prizeList);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid positive integer");
                }
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "There was an error in the box.");
        }
    }
}
