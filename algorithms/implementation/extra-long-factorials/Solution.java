import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            String nS = bf.readLine().trim();
            int n = Integer.parseInt(nS);
            BigInteger inc = new BigInteger("2");
            BigInteger fact = BigInteger.ONE;
            while(n-- > 1) {
                fact = inc.multiply(fact);
                inc = inc.add(BigInteger.ONE);
            }

            System.out.println(fact);

        } catch (IOException e) {}
    }
}
