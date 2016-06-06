import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] greaters = new int [n];
        int [] lessers = new int [n];
        int pivot = sc.nextInt();
        int g = 0; int l = 0;
        int temp;

        for(int i =0; i<n-1; i++) {
            temp = sc.nextInt();
            if(temp < pivot)
                lessers[l++] = temp;
            else
                greaters[g++] = temp;
        }

        int i;
        for(i =0; i<l; i++)
            System.out.print(lessers[i]+" ");
        System.out.print(pivot+" ");
        for(i =0; i<g; i++)
            System.out.print(greaters[i]+" ");
        System.out.println();
    }
}
