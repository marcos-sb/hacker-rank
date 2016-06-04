import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String anagramPalindrome = sc.nextLine();
        int [] counts = new int['z' - 'a' + 1];
        for(int i = 0; i < anagramPalindrome.length(); i++)
            counts[anagramPalindrome.charAt(i) - 'a']++;

        String result = "YES";
        if(anagramPalindrome.length() % 2 == 0) {
            for(int count : counts)
                if(count % 2 != 0) result = "NO";
        } else {
            int oddCount = 0;
            for(int c : counts)
                if(c % 2 != 0) oddCount++;
            if(oddCount > 1) result = "NO";
        }

        System.out.printf("%s%n", result);
    }
}
