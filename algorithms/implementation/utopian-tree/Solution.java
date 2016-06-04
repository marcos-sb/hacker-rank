import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int N;
        while(T-- > 0) {
            N = sc.nextInt();

            System.out.printf("%d%n", growthAfter(N));
        }
    }

    private static int growthAfter(int N) {
        if(N == 0) return 1;
        int size = 1;
        while(N-- > 0) {
            size *= 2;
            if(N-- > 0) size +=1;
        }
        return size;
    }

}
