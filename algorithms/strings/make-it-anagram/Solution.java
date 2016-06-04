import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            String a = bf.readLine();
            String b = bf.readLine();

            int [] freqs = new int ['z' - 'a' + 1];

            for(int i =0; i<a.length(); i++)
                freqs['z' - a.charAt(i)]++;
            for(int i = 0; i<b.length(); i++)
                freqs['z' - b.charAt(i)]--;

            int count = 0;
            for(int f : freqs)
                count += Math.abs(f);

            System.out.println(count);
        } catch(IOException e) {}
    }
}
