import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N; String N_str; int count = 0; int n;

        while(T-- > 0) {
            N = sc.nextInt();
            N_str = String.valueOf(N);
            count = 0;
            for(int i = 0; i < N_str.length(); i++) {
                n = Character.getNumericValue(N_str.charAt(i));
                if(n != 0 && N % n == 0) count++;
            }
            System.out.printf("%d%n",count);
        }
    }
}
