package eTestW12;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class IntegerArrays {
    private static int EXIT_CODE = Integer.MAX_VALUE;
    private static String PART_1_RESPONSE_TEST = "The magnitude of the range of values is ";

    public static void main(String[] args) {
        boolean quit = false;
        int[] intArray = new int[0];
        do {
            intArray = Arrays.copyOf(intArray, intArray.length + 1);
            int intToAdd = getInt("Enter an integer to add to the array (or 'quit' to finish)");
            if (intToAdd == EXIT_CODE) {
                quit = true;
            } else {
                intArray[intArray.length - 1] = intToAdd;
                int rangeMagnitude = rangeMagnitude(intArray);
                boolean allValuesEven = allIntsEven(intArray);
                if (allValuesEven) {
                    JOptionPane.showMessageDialog(null, PART_1_RESPONSE_TEST + rangeMagnitude
                            + ", and all values are even");
                } else {
                    JOptionPane.showMessageDialog(null, PART_1_RESPONSE_TEST + rangeMagnitude
                            + ", and not all values are even");
                }
            }
        } while (!quit);

    }

    private static boolean allIntsEven(int[] intArr) {
        boolean result = true;
        for (int value : intArr) {
            if (value % 2 != 0) {
                result = false;
            }
        }
        return result;
    }

    private static int rangeMagnitude(int[] intArr) {
        if (intArr.length > 1) {
            int tempMax = Integer.MIN_VALUE;
            int tempMin = Integer.MAX_VALUE;
            for (int value : intArr) {
                if (value > tempMax) {
                    tempMax = value;
                }
                if (value < tempMin) {
                    tempMin = value;
                }
            }
            return Math.abs(tempMax - tempMin);
        } else {
            return 0;
        }
    }

    private static int getInt(String message) {
        try {
            String inputBox = JOptionPane.showInputDialog(message);
            Scanner inputParse = new Scanner(inputBox);
            if (inputParse.hasNextInt()) {
                return inputParse.nextInt();
            } else if (inputParse.hasNext("quit")) {
                return EXIT_CODE;
            } else {
                return getInt(message);
            }
        } catch (Exception exception) {
            System.out.println("User hit Cancel");
            return EXIT_CODE;
        }


    }
}
