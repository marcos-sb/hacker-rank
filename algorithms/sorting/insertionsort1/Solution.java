import java.io.*;
import java.util.*;

public class Solution {

    private static void prArr(int [] arr) {
        for(int n : arr) System.out.printf("%d ", n);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int [] arr = new int [s];
        int i,j;
        for(i = 0; i<s; i++) {
            arr[i] = sc.nextInt();
        }

        int V = arr[s-1];
        int temp;
        boolean end = false;
        for(i = s-2; i>=0; i--) {
            j = i+1;
            if(arr[i] > V)
                arr[j] = arr[i];
            else {
                arr[j] = V;
                end = true;
            }
            prArr(arr);
            if(end) break;
        }
        if(!end) {
            arr[0] = V;
            prArr(arr);
        }
    }
}
