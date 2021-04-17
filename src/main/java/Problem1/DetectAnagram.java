package Problem1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Lisa Ramel
 * Date: 2021-04-14
 * Time: 13:35
 * Project: ProgrammingTest
 * Copywrite: MIT
 */
public class DetectAnagram {

    public Boolean findAnagram(String firstWord, String secondWord){

        // Creates a CharArray for each of the parameters firstWord and secondWord
        // Removes all whitespaces
        char[] wordOne = firstWord.toLowerCase().replaceAll(" ", "").toCharArray();
        char[] wordTwo = secondWord.toLowerCase().replaceAll(" ", "").toCharArray();

        // Sorts the two CharArrays
        Arrays.sort(wordOne);
        Arrays.sort(wordTwo);

        // Checks if the two CharArrays contains the same values and returns true if so
        return Arrays.equals(wordOne, wordTwo);
    }

    public static void main(String[] args) throws InterruptedException {

        while(true) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Is it an anagram?");
            Thread.sleep(800);

            // Saves each input as a string
            System.out.println("Enter the first word:");
            String firstWord = scan.nextLine();
            if(firstWord.equals("")){
                System.exit(0);
            }
            System.out.println("Enter the second word:");
            String secondWord = scan.nextLine();

            DetectAnagram da = new DetectAnagram();
            System.out.println(da.findAnagram(firstWord, secondWord) + "!");
            System.out.println();
        }
        
    }
}
