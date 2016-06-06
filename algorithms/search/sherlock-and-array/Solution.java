import java.io.*;
import java.util.*;

public class Solution {

    private static long sumRightFromExcluding(int i, int [] arr) {
        long currSum = 0l;
        if(arr.length <= 1) return 0l;
        for(int j = i+1; j<arr.length; j++)
            currSum += arr[j];

        return currSum;
    }

    private static boolean travelArray(int [] arr) {
        long left = 0;
        long right = sumRightFromExcluding(0, arr);
        if(left == right) return true;

        for(int i = 1; i<arr.length; i++) {
            if(left == right) return true;
            left += arr[i-1]; right -= arr[i];
        }
        return false;
    }

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            int t = Integer.parseInt(bf.readLine().trim());
            int n; String [] input; int [] arr; String result;
            while(t-- > 0) {
                n = Integer.parseInt(bf.readLine().trim());
                input = bf.readLine().split(" ");
                arr = new int [n];
                for(int i = 0; i<n; i++)
                    arr[i] = Integer.parseInt(input[i]);
                result = travelArray(arr) ? "YES" : "NO";
                System.out.println(result);
            }

        } catch(IOException e) {}
    }
}
