import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(bf.readLine());
            long n, mask = 1l;
            int ones, shifts, rightmostbitpos;
            while(t-- > 0) {
                ones = 0;
                shifts = 0;
                rightmostbitpos = 0;
                n = Long.parseUnsignedLong(bf.readLine());
                if(n == 1) {
                    System.out.println("Richard");
                    continue;
                }
                for(long i = n; i != 0; i >>>= 1) {
                    shifts++;
                    if((i & mask) == 1) {
                        if(rightmostbitpos == 0) rightmostbitpos = shifts;
                        ones++; // power of 2 <=> ones == 1
                    }
                }
                if((ones + rightmostbitpos) % 2 == 0) System.out.println("Richard");
                else System.out.println("Louise");
            }

        } catch(IOException e) {}
    }
}
