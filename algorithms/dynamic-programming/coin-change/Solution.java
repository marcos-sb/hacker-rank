
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    private static long[][] cache;

    private static long makeChange(int amount, int [] coins, int coin) {
        if(amount == 0)
            return 1;
        if(coin < 0 || amount < 0) return 0;
        if(cache[amount][coin] > 0) return cache[amount][coin];

        long total = makeChange(amount, coins, coin-1) + makeChange(amount-coins[coin], coins, coin);
        cache[amount][coin] = total;
        return total;
    }

    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            String [] line = bf.readLine().trim().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int [] arr = new int [m];
            line = bf.readLine().trim().split(" ");

            for(int i = 0; i<m; i++)
                arr[i] = Integer.parseInt(line[i]);

            cache = new long [n+1][m];

            System.out.println(makeChange(n, arr, m-1));

        } catch(IOException e) {}
    }
}
