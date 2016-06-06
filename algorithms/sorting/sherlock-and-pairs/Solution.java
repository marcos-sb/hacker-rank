import java.io.*;
import java.util.*;

public class Solution {

    private static long quickPermsNoRepetition(int n, int r) {
        long res = 1;
        while(r-- > 0)
            res *= n--;
        return res;
    }

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            int t = Integer.parseInt(bf.readLine());
            int n,i;
            String [] line;
            int [] counts;
            final int MAX_VALUE = (int) 1E6;
            long pairCount;

            while(t-- > 0) {
                pairCount = 0l;
                counts = new int [MAX_VALUE+1];
                n = Integer.parseInt(bf.readLine());
                line = bf.readLine().split(" ");
                for(i = 0; i<n; i++)
                    counts[Integer.parseInt(line[i])]++;

                for(i = 0; i<=MAX_VALUE; i++)
                    if(counts[i] > 1)
                        pairCount += quickPermsNoRepetition(counts[i],2);

                System.out.println(pairCount);
            }

        } catch (IOException e) {

        }
    }
}
