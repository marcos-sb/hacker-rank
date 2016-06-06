
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {

    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            String [] line = bf.readLine().split(" ");
            BigInteger a = new BigInteger(String.valueOf(Integer.parseInt(line[0])));
            BigInteger b = new BigInteger(String.valueOf(Integer.parseInt(line[1])));
            int n = Integer.parseInt(line[2]);
            BigInteger c = BigInteger.ZERO;

            for(int i = 2; i<n; i++) {
                c = a.add(b.multiply(b));
                a = b;
                b = c;
            }

            System.out.println(c);


        } catch(IOException e) {}
    }
}
