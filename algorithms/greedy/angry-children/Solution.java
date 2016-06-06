import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long [] candies = new long [N];

        for(int k = 0; k < N; k++)
            candies[k] = sc.nextLong();

        Arrays.sort(candies);

        long minUnfairness = (long) Math.pow(10,9);
        for(int i = 0; i < N - K; i++)
            minUnfairness = Math.min(candies[i + K - 1] - candies[i], minUnfairness);

        System.out.printf("%d%n", minUnfairness);
    }
}
