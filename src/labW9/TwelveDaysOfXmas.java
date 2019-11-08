package labW9;

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
