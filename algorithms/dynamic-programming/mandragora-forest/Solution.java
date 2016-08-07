import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    private static long play(final long [] arr) {
        long s = 1L;
        long p = 0L;
        for(long mand : arr)
            p += mand;
        long maxp = p;
        for(long mand : arr) {
            s += 1;
            p -= mand;
            if(maxp < s * p) maxp = s * p;
            else if(maxp > s * p) return maxp;
        }
        return maxp;
    }
    public static void main(String [] args) {
        try(final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(bf.readLine());
            while(t-- > 0) {
                final int n = Integer.parseInt(bf.readLine());
                final long [] mandrgs = new long [n];
                int i = 0;
                for(String s : bf.readLine().split(" "))
                    mandrgs[i++] = Long.parseLong(s);
                Arrays.sort(mandrgs);
                System.out.println(play(mandrgs));
            }
        } catch(IOException ex) {}
    }
}
