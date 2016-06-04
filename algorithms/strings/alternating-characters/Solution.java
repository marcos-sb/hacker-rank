import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.valueOf(bf.readLine().trim());
            String s;
            while(T-- > 0) {
                s = bf.readLine().trim();
                System.out.printf("%d%n", deletions(s));
            }
        } catch (IOException ex) {}
    }

    private static int deletions(String s) {
        if(s.length() == 0) return 0;

        int dels = 0;
        char prev = s.charAt(0);
        char curr;
        for(int i = 1; i < s.length(); i++) {
            curr = s.charAt(i);
            if(prev == curr) {
                dels++;
            } else {
                prev = curr;
            }
        }
        return dels;
    }
}
