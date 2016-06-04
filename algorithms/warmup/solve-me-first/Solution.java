import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int [] a = new int [2];
        int i = 0;
        while(sc.hasNextInt()) {
            a[i++] = sc.nextInt();
        }
        System.out.println(a[0] + a[1]);
    }
}
