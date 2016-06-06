import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            String [] fl = bf.readLine().trim().split(" ");
            int n = Integer.parseInt(fl[0]); long k = Long.parseLong(fl[1]);
            String [] sl = bf.readLine().trim().split(" ");
            long [] prices = new long [n];

            for(int i = 0; i<n; i++)
                prices[i] = Long.parseLong(sl[i]);

            Arrays.sort(prices);

            int count = 0;
            while(n-- > 0 && k > prices[count])
                k -= prices[count++];

            System.out.println(count);

        } catch (IOException e) {}
    }
}
