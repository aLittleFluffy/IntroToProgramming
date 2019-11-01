package labW8;

/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 5
       Comment: All numbers and frequently used words are listed as constants
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 5
       Comment: Each constant name is properly formatted and shows what the constant is used for
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 10: 10
       COmment: All variables are properly formatted and the variable names are descriptive
   4. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: Code is autoformatted by the IDE
   5. Did I use an appropriate loop (or loops) to produce the different verses?
       Mark out of 20: 20
       Comment: Used a for loop to iterate through days, this is the correct loop for this scenario.
   6. Did I use a switch to build up the verses?
       Mark out of 25: 25
       Comment: A switch statment is used to add the correct verse for the day.
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))?
       Mark out of 10: 10
       Comment: The verses are built up through each loop, as such each verse is only written once
   8. Does the program produce the correct output?
       Mark out of 10: 10
       Comment: The Program prints the correct output to the console.
   9. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: All marks and comments filled out correctly
   Total Mark out of 100 (Add all the previous marks): 100
*/

public class twelveDaysOfXmas {
    private static int DAYS_OF_XMAS = 12;
    private static String[] DAY_WORDS = {"first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth"};
    public static void main(String[] args) {
        String accumulatedGifts = "";
        for(int day = 1; day<=DAYS_OF_XMAS; day++){
            String wordDay = DAY_WORDS[day-1];
            String response = "On the " + wordDay + " of Christmas\nMy true love sent to me:\n";
            switch(day){
                case 1:
                    accumulatedGifts = accumulatedGifts + "a Partridge in a pear tree";
                    break;
                case 2:
                    accumulatedGifts = "2 turtle doves\nand "+accumulatedGifts;
                    break;
                case 3:
                    accumulatedGifts = "3 french hens,\n" + accumulatedGifts;
                    break;
                case 4:
                    accumulatedGifts = "4 calling birds,\n" + accumulatedGifts;
                    break;
                case 5:
                    accumulatedGifts = "5 Golden rings,\n" + accumulatedGifts;
                    break;
                case 6:
                    accumulatedGifts = "6 geese-a-laying,\n" + accumulatedGifts;
                    break;
                case 7:
                    accumulatedGifts = "7 swans a-swimming,\n" + accumulatedGifts;
                    break;
                case 8:
                    accumulatedGifts = "8 maids a-milking,\n" + accumulatedGifts;
                    break;
                case 9:
                    accumulatedGifts = "9 ladies dancing,\n" + accumulatedGifts;
                    break;
                case 10:
                    accumulatedGifts = "10 lords a-leaping,\n" + accumulatedGifts;
                    break;
                case 11:
                    accumulatedGifts = "11 pipers piping,\n" + accumulatedGifts;
                    break;
                case 12:
                    accumulatedGifts = "12 drummers drumming,\n" + accumulatedGifts;
                    break;
                default:
                    break;
            }
            System.out.println(response+accumulatedGifts+"\n\n");
        }
    }
}
