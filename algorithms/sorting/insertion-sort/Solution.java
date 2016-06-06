import java.io.*;
import java.util.*;

public class Solution {

    private static long read(int [] tree, int index) {
        long sum = 0;
        while(index > 0) {
            sum += tree[index];
            index -= (index & -index);
        }
        return sum;
    }

    private static void update(int [] tree, int index, int value) {
        while(index < tree.length) {
            tree[index] += value;
            index += (index & -index);
        }
    }

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int t = Integer.parseInt(bf.readLine());
            int n, i, x;
            int max = 1000000;
            String [] line;
            int [] tree;
            long inversions;

            while(t-- > 0) {
                tree = new int [max+1];
                n = Integer.parseInt(bf.readLine());
                line = bf.readLine().split(" ");
                inversions = 0;
                for(i = n-1; i>=0; i--) {
                    x = Integer.parseInt(line[i]);
                    inversions += read(tree, x-1);
                    update(tree, x, 1);
                }

                System.out.println(inversions);
            }
        } catch(IOException e) {}
    }
}
