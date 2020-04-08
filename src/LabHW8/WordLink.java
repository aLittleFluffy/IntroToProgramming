package LabHW8;

/* SELF ASSESSMENT

1. readDictionary
- I have the correct method definition [Mark out of 5: 5]
- Comment: Returns arraylist. Method called readDictionary, takes no input
- My method reads the words from the "words.txt" file. [Mark out of 5: 5]
- Comment: Uses words.txt file saved at src/
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5: 5]
- Comment: See above

2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: readWordList handles user input
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5: 5]
- Comment: reads words properly and saves them to arraylist of strings

3. isUniqueList
- I have the correct method definition [Mark out of 5: 5]
- Comment: isUniqueList is static
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5: 5]
- Comment: each word is compared with everyword but itself.
- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
- Comment: Returns false if non-unique word found
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: Only reaches return true; line if all words are unique

4. isEnglishWord
- I have the correct method definition [Mark out of 5: 5]
- Comment: static
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: Uses binarySearch from collections because dictionary is an ArrayList
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: Yes

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment:static
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: yes, adds all differences, if number of differences greater than 1, false returned.

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment:Static
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment:Implements previously listed methods

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10: 10]
- Comment: word handling in readDictionary.
- Asks the user for input and calls isWordChain [Mark out of 5: 5]
- Comment: User input handled in read WordList

 Total Mark out of 100 (Add all the previous marks): 100
*/



import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class WordLink{
    public static void main(String[] args) {
        System.out.print("Loading Dictionary ... ");
        ArrayList<String> dictionary = readDictionary();
        boolean quit = false;
        do {
            ArrayList<String> wordList = readWordList();
            if(wordList.size()==0) quit=true;
            else {
                System.out.println("Wordlist loaded");
                if(isWordChain(wordList, dictionary)){
                    System.out.println("Is word Chain");
                    JOptionPane.showMessageDialog(null, "Valid chain of words from Lewis Carroll's word-links game.");
                } else {
                    JOptionPane.showMessageDialog(null, "Not a valid chain of words from Lewis Carroll's word-links game.");
                }
            }
        } while(!quit);
    }
    static ArrayList<String>  readDictionary(){
        ArrayList<String> dictionary = new ArrayList<String>();
        try{
            FileInputStream fin = new FileInputStream("src/LabHW8/words.txt");
            int i=0;
            String currWord = "";
            while((i=fin.read())!=-1){
                if((char)i=='\n'){
                    dictionary.add(currWord);
                    currWord = "";
                } else currWord+=(char)i;
            }
            fin.close();
            System.out.println("Finished Loading");
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            return dictionary;
        }

    }

    static ArrayList<String> readWordList(){
        ArrayList<String> returnArr = new ArrayList<String>();
        try {
            String input = JOptionPane.showInputDialog("Enter a comma separated list of strings (or an empty list to quit): ");
            Scanner inputParser = new Scanner( input ).useDelimiter(", ");
            while(inputParser.hasNext()){
                String nextString = inputParser.next();
                returnArr.add(nextString);
            }
            System.out.println("Added to arraylist");
            inputParser.close();
        } catch (Exception e){ System.out.println(e);}
        finally {
            return returnArr;
        }
    }

    static boolean isUniqueList(ArrayList<String> wordList){
        for (int i = 1; i < wordList.size(); i++) {
            if(wordList.get(i-1).equals(wordList.get(i))) return false;
        }
        return true;
    }

    static boolean isEnglishWord(String word, ArrayList<String> dictionary){
        if(Collections.binarySearch(dictionary, word)<=0) {
            System.out.println(dictionary.indexOf(word));
            System.out.println(word +" is not english");
            return false;
        }
        else return true;
    }

    static boolean isDifferentByOne(String str1, String str2) {
        if (str1.length() == str2.length()) {
            int diffCount = 0;
            for (int i = 0; i < str1.length(); i++) {
                if(str1.charAt(i)!=str2.charAt(i)) diffCount++;
            }
            if(diffCount>1) return false;
            else return true;
        } else return false;
    }

    static boolean isWordChain(ArrayList<String> wordList, ArrayList<String> dictionary) {
        if (isUniqueList(wordList)) {
            boolean allWordsEnglish = true;
            for (String word : wordList) {
                allWordsEnglish = isEnglishWord(word, dictionary);
            }
            if (allWordsEnglish) {
                for (int i = 1; i < wordList.size(); i++) {
                    if (!isDifferentByOne(wordList.get(i - 1), wordList.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
