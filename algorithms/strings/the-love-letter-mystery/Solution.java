import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int T = Integer.valueOf(bf.readLine().trim());
            String s;
            while(T-- > 0) {
                s = bf.readLine().trim();
                System.out.printf("%d%n", edits(s));
            }

        } catch(IOException ex) {

        }
    }

    private static int edits(String s) {
        if(s.length() == 0) return 0;
        int halfSize = s.length() / 2;

        int edits = 0;
        for(int i = 0; i < halfSize; i++)
            edits += Math.abs(s.charAt(i) - s.charAt(s.length() - 1 - i));

        return edits;
    }

}
