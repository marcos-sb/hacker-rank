
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution {

    public static void main(String [] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(bf.readLine());
            String [] line = bf.readLine().split(" ");
            long [] arr = new long [n];
            for(int i = 0; i<n; i++)
                arr[i] = Long.parseLong(line[i]);
            line = bf.readLine().split(" ");
            long p = Long.parseLong(line[0]);
            long q = Long.parseLong(line[1]);

            Arrays.sort(arr);

            long min;
            long max_min_j = 0l;
            int k = 0;
            long diff = 0l;
            long newDiff, newMaxMinJ;
            while(k < n-1) {
                newDiff = Math.abs(arr[k] - arr[k+1]) / 2;
                newMaxMinJ = newDiff + arr[k];
                if(newDiff > diff && newMaxMinJ >= p && newMaxMinJ <= q) {
                    diff = newDiff;
                    max_min_j = newMaxMinJ;
                }
                k++;
            }
            long [] helper = new long [2];
            helper[0] = p; helper[1] = q;
            for(int j = 1; j>=0; j--) {
                k = 0;
                min = Long.MAX_VALUE;
                while(k < n) {
                    newDiff = Math.abs(helper[j] - arr[k]);
//                    System.out.printf("%n%d %d %d", newDiff, arr[k], helper[j]);
                    if(min > newDiff) {
                        min = newDiff;
                        k++;
                    } else break;

                }
                if(diff <= min) {
                    diff = min;
                    max_min_j = helper[j];
                }
            }

            System.out.println(max_min_j);

        } catch(IOException e) {}
    }
}
