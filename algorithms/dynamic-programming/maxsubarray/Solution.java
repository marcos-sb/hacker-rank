import java.io.*;
import java.util.*;

public class Solution {

    private static int maxSubSeq(int [] arr, int [] maxSubSeqi, int i, int max) {
        if(i == 0) maxSubSeqi[0] = arr[0];
        else maxSubSeqi[i] = Math.max(arr[i] + maxSubSeqi[i-1], arr[i]);

        max = Math.max(maxSubSeqi[i], max);

        if(i == arr.length-1) return max;
        else return maxSubSeq(arr, maxSubSeqi, i+1, max);
    }

    private static int sumPositives(int [] arr) {
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++)
            sum = Math.max(sum, arr[i]);

        if(sum > 0) {
            sum = 0;
            for(int i = 0; i<arr.length; i++)
                if(arr[i] > 0)
                    sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            String [] line;
            int t = Integer.parseInt(bf.readLine());
            int n;
            int [] arr, maxSS;
            while(t-- > 0) {
                n = Integer.parseInt(bf.readLine());
                line = bf.readLine().split(" ");
                arr = new int [n];
                maxSS = new int [n];
                for(int i = 0; i<n; i++)
                    arr[i] = Integer.parseInt(line[i]);

                System.out.print(maxSubSeq(arr, maxSS, 0, Integer.MIN_VALUE) + " " + sumPositives(arr));
                System.out.println();
            }

        } catch(IOException e) {}
    }
}
