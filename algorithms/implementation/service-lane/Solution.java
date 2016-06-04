import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ) {

            String [] line = bf.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int t = Integer.parseInt(line[1]);

            line = bf.readLine().split(" ");
            int [] width = new int [n];

            for(int i = 0; i<n; i++)
                width[i] = Integer.parseInt(line[i]);

            int from, to, min;

            while(t-- > 0) {
                min = 3;
                line = bf.readLine().split(" ");
                from = Integer.parseInt(line[0]);
                to = Integer.parseInt(line[1]);
                for(int i = from; i<=to; i++) {
                    min = Math.min(min, width[i]);
                }
                System.out.println(min);
            }

        } catch(IOException e) {}
    }
}
