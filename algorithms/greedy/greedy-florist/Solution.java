import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String[] line = bf.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            int [] cis = new int [n];
            line = bf.readLine().split(" ");
            for(int i = 0; i<n; i++)
                cis[i] = Integer.parseInt(line[i]);

            Arrays.sort(cis);
            int flowersPerFriend = 0;
            int cost = 0;
            for(int i = n-1; i>=0; i--) {
                cost += cis[i]*(flowersPerFriend+1);
                if((n - i) % k == 0) flowersPerFriend++;
            }

            System.out.println(cost);

        } catch(IOException e) {}
    }
}
