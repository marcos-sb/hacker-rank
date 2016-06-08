import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            int t = Integer.parseInt(bf.readLine());
            long val;
            long mask = (1l << 32) - 1;

            while(t-- > 0) {
                val = Long.parseLong(bf.readLine());
                System.out.println(~val & mask);
            }

        } catch(IOException e) {}
    }
}
