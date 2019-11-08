package labW9;
/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningfu,l properly formatted, variable names and CONSTANTS?
        Mark out of 10: 10
        Comment:   All variables and constants are properly formatted and show what the variable represents.
 2. Did I implement the getVerse function correctly and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  The getVerse is properly defined, called, and implemented as it generates the verse for each day correctly.
 3. Did I implement the getChristmasGift function correctly using a switch statement and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  The function properly returns the christmas gift as a string to be used by getVerse
 4. Did I implement the getOrdinalString function correctly using if or conditional operators and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  The function returns the day as a string to be used by getVerse
 5. Does the program produce the output correctly?
       Mark out of 10: 10
        Comment:  The program outputs the correct content, in this case the song 12 days of christmas
 6. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: Assessment is completed thoroughly and correctly
 Total Mark out of 100 (Add all the previous marks): 100
*/
public class TwelveDaysOfXmas {
    private static int MAX_DAYS = 12;
    public static void main(String[] args) {
        for(int count = 1; count<=MAX_DAYS; count++){
            System.out.println(getVerse(count));
        }
    }
    static String getVerse(int day){
        String xMasGifts = "";
        for(int count = 1; count<=day; count++){
            xMasGifts = getChristmasGift(count) + xMasGifts;
        }
        String verse = "On the " + getOrdinalString(day) + " day of Christmas, my true love sent to me\n" + xMasGifts;
        return verse;
    }
    static String getChristmasGift(int giftNum){
        switch(giftNum){
            case 1:
                return "a partridge in a pear tree\n";
            case 2:
                return "two turtle doves\nand ";
            case 3:
                return "three french hens\n";
            case 4:
                return "four calling birds\n";
            case 5:
                return "five gold rings\n";
            case 6:
                return "six geese a-laying\n";
            case 7:
                return "seven swans a-swimming\n";
            case 8:
                return "eight maids a-milking\n";
            case 9:
                return "nine ladies dancing\n";
            case 10:
                return "ten lords a-leaping\n";
            case 11:
                return "eleven pipers piping\n";
            case 12:
                return "twelve drummers drumming\n";
            default:
                return "";
        }
    }
    static String getOrdinalString(int number){
        switch(number){
            case 1:
                return "first";
            case 2:
                return "second";
            case 3:
                return "third";
            case 4:
                return "fourth";
            case 5:
                return "fifth";
            case 6:
                return "sixth";
            case 7:
                return "seventh";
            case 8:
                return "eighth";
            case 9:
                return "ninth";
            case 10:
                return "tenth";
            case 11:
                return "eleventh";
            case 12:
                return "twelfth";
            default:
                return "";
        }
    }
}
