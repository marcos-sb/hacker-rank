import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in))
            ) {

            int n = Integer.parseInt(in.readLine().trim());
            int i, k;
            StringBuilder [] ordered = new StringBuilder [n];
            String [] tokenLine;

            for(i = 0; i<n; i++)
                ordered[i] = new StringBuilder();

            for(i = 0; i<n/2; i++) {
                tokenLine = in.readLine().split(" ");
                k = Integer.parseInt(tokenLine[0]);
                ordered[k].append("- ");
            }

            for(i = n/2; i<n; i++) {
                tokenLine = in.readLine().split(" ");
                k = Integer.parseInt(tokenLine[0]);
                ordered[k].append(tokenLine[1]).append(" ");
            }

            for(StringBuilder sb : ordered)
                System.out.print(sb);

        } catch(IOException e) {}
    }
}
