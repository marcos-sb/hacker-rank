import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int [] a = new int [s];
        int temp, i, j;

        for(i = 0; i<s; i++)
            a[i] = sc.nextInt();

        for(i = 1; i<s; i++) {
            for(j = i; j > 0 && a[j] < a[j-1]; j--) {
                temp = a[j-1];
                a[j-1] = a[j];
                a[j] = temp;
            }
            for(int k : a)
                System.out.print(k+" ");
            System.out.println();
        }
    }
}
