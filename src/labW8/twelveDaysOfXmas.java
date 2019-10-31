package labW8;

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
