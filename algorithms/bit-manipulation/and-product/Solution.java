
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(bf.readLine());
            String [] line;
            while(t-- > 0) {
                line = bf.readLine().split(" ");
                long a = Long.parseLong(line[0]);
                long b = Long.parseLong(line[1]);
                long left = Long.highestOneBit(b);
                long right = Long.highestOneBit(a) << 1;
                if(a < left || right <= b) // a <= 2^x <= b, x Nat
                    System.out.println("0");
                else {
                    System.out.println(a & ~((Long.highestOneBit(b-a) << 1) - 1) & b);
                }
            }

        } catch(IOException e) {}
    }
}
