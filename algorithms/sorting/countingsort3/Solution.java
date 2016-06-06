import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] counts = new int [101];

        while(n-- > 0) {
            counts[sc.nextInt()+1]++;
            sc.nextLine();
        }

        for(int i = 1; i<counts.length; i++)
            counts[i] += counts[i-1];

        for(int i = 1; i<counts.length; i++)
            System.out.print(counts[i]+" ");
        System.out.println();
    }
}
