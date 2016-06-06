import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int [n];

        for(int i = 0; i<n; i++)
            a[i] = sc.nextInt();

        int temp, count = 0;
        for(int i = 1; i<n; i++)
            for(int j = i; j>0 && a[j] < a[j-1]; j--) {
                temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                count++;
            }
        System.out.print(count);
    }
}
