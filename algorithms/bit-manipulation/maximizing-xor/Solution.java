import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        if(l==r) {
            System.out.printf("%d%n",0); return;
        }
        int max = 0;
        for(int a = l; a < r; a++)
            for(int b = a + 1; b <=r; b++)
                if((a ^ b) > max)
                    max = a ^ b;
        System.out.printf("%d%n", max);
    }
}
