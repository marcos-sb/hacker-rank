import java.io.*;
import java.util.*;

public class Solution {

    private static int totalValue, minDiff;

    private static int dfs(int node, ArrayList<Integer> [] adj, int [] value, boolean [] marked) {
        marked[node] = true;
        int subTreeValue = value[node];
        for(Integer child : adj[node]) {
            if(marked[child]) continue;
            subTreeValue += dfs(child, adj, value, marked);
        }

        minDiff = Math.min(minDiff, Math.abs(totalValue - 2*subTreeValue));

        return subTreeValue;
    }

    public static void main(String[] args) {
        try (
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            int n = Integer.parseInt(bf.readLine());
            String [] line = bf.readLine().split(" ");
            int [] value = new int [n];
            boolean [] marked = new boolean [n];

            ArrayList<Integer> [] adj = new ArrayList [n];
            totalValue = 0;
            for(int i = 0; i<n; i++) {
                value[i] = Integer.parseInt(line[i]);
                adj[i] = new ArrayList<>();
                totalValue += value[i];
            }

            minDiff = totalValue;

            int s, d;
            for(int i = 0; i<n-1; i++) { // n-1 lines
                line = bf.readLine().split(" ");
                s = Integer.parseInt(line[0]);
                d = Integer.parseInt(line[1]);
                adj[s-1].add(d-1); adj[d-1].add(s-1);
            }

            dfs(0, adj, value, marked);

            System.out.println(minDiff);

        } catch(IOException e) {}
    }
}
