import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N,C,M, free, wrappers, totalChocolates;

        while(T-- > 0) {
            N = sc.nextInt();
            C = sc.nextInt();
            M = sc.nextInt();
            totalChocolates = N / C;
            wrappers = totalChocolates;
            while(wrappers >= M) {
                free = wrappers / M;
                wrappers += free - M*free;
                totalChocolates += free;
            }

            System.out.println(totalChocolates);
        }
    }
}
