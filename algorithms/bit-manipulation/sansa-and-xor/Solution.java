import java.io.*;
import java.util.*;

public class Solution {

    public static int generalXORMethod(int [] arr) {
        int xor = arr[0];
        for(int i = 2; i<arr.length; i+=2) {
            xor ^= arr[i];
        }

        return xor;
    }

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int t = Integer.parseInt(bf.readLine());
            int n, i;
            String [] line;
            int [] arr;

            while (t-- > 0) {
                n = Integer.parseInt(bf.readLine());
                line = bf.readLine().split(" ");
                if(n % 2 == 0) {
                    System.out.println(0);
                    continue;
                }

                arr = new int [n];
                for(i = 0; i<n; i++)
                    arr[i] = Integer.parseInt(line[i]);

                System.out.println(generalXORMethod(arr));
            }
        } catch (IOException e) {}
    }
}
