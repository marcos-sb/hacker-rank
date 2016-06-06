import java.io.*;
import java.util.*;

public class Solution {

    private static List<Integer> missingNs(int [] a, int [] b, final int max) {
        int [] freqA, freqB;
        int i;
        ArrayList<Integer> res = new ArrayList<>();

        freqA = new int [max+1];
        freqB = new int [max+1];

        for(i=0; i<a.length; i++) freqA[a[i]]++;
        for(i=0; i<b.length; i++) freqB[b[i]]++;

        for(i=1; i<max+1; i++)
            if(freqA[i] < freqB[i])
                res.add(i);

        return res;
    }

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {
            final int MAXVAL = (int) 1e4;
            int n = Integer.parseInt(bf.readLine());
            String [] line = bf.readLine().split(" ");

            int [] a = new int [n];
            int i;
            for(i = 0; i<n; i++)
                a[i] = Integer.parseInt(line[i]);

            int m = Integer.parseInt(bf.readLine());
            int [] b = new int [m];
            line = bf.readLine().split(" ");
            for(i=0; i<m; i++)
                b[i] = Integer.parseInt(line[i]);

            for(Integer val : missingNs(a, b, MAXVAL))
                System.out.print(val + " ");

        } catch(IOException e) {}
    }
}
