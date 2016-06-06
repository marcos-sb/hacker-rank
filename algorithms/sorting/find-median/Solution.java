import java.io.*;
import java.util.*;

public class Solution {

    private static int partition(int [] arr, int hi, int [] part1, int [] part2) {
        int pivot; int toLeft = 0; int toRight = 0;

        do {
            pivot = arr[hi];
            int k1 = 0; int k2 = 0;
            for(int i = 0; i<hi; i++) {
                if(arr[i] < pivot) {
                    part1[k1++] = arr[i];
                } else {
                    part2[k2++] = arr[i];
                }
            }

            if(toLeft + k1 == toRight + k2) break;

            if(toLeft + k1 <= toRight + k2) {
                toLeft += k1+1; // #part1 + pivot
                hi = k2-1;
                arr = part2;
                part2 = new int [k2];
            } else {
                toRight += k2+1; // #part2 + pivot
                hi = k1 - 1;
                arr = part1;
                part1 = new int[k1];
            }

        } while(true);

        return pivot;
    }

    public static void main(String[] args) {
        try (
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        )
        {

            int n = Integer.parseInt(bf.readLine());
            String [] temp;
            int [] arr = new int [n];
            int k = 0;

            temp = bf.readLine().split(" ");
            for(String s : temp)
                arr[k++] = Integer.parseInt(s);

            System.out.print(partition(arr, arr.length-1, new int [n], new int[n]));

        } catch(IOException e) {}
    }
}
