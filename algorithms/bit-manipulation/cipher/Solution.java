import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            String [] line = bf.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            String s = bf.readLine().trim();
            boolean [] k_history = new boolean [k];

            int j;
            boolean newXor, xor_history = false;
            StringBuilder b = new StringBuilder(n);
            for(int i = 0; i<n; i++) {
                j = i % k;
                newXor = k_history[j] ^ (s.charAt(i) == '1' ? true : false) ^ xor_history;
                xor_history = newXor ^ k_history[j] ^ xor_history;
                k_history[j] = newXor;
                b.append(newXor ? '1': '0');
            }

            System.out.println(b.toString());

        } catch(IOException e) {}
    }
}
