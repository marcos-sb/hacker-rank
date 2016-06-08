import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(bf.readLine());
            BigInteger modded = new BigInteger("1000000007");
            while(t-- > 0) {
                int n = Integer.parseInt(bf.readLine());
                String [] arrS = bf.readLine().split(" ");
                int res = 0;
                BigInteger shifted = BigInteger.ONE.shiftLeft(n-1).mod(modded);
                for(int i =0; i<n; i++)
                    res |= Integer.parseInt(arrS[i]);

                System.out.println(new BigInteger(String.valueOf(res)).multiply(shifted).mod(modded));
            }

        } catch(IOException e) {}
    }
}
