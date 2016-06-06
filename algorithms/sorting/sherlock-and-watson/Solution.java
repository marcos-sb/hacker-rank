import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            String [] line = bf.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            int q = Integer.parseInt(line[2]);

            int [] arr = new int [n];
            line = bf.readLine().split(" ");
            for(int i = 0; i<n; i++)
                arr[i] = Integer.parseInt(line[i]);

            int [] rotpos2pos = new int [n];
            for(int i = 0; i<n; i++)
                rotpos2pos[(i + k) % n] = i;

            int pos;
            while(q-- > 0) {
                pos = Integer.parseInt(bf.readLine());
                System.out.println(arr[rotpos2pos[pos]]);
            }

        } catch(IOException e) {}
    }
}
