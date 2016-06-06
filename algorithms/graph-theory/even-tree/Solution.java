import java.io.*;

public class Solution {

    private static final int MAX_N = 100;
    private static int removedEdges = 0;

    private static int fillNeighCount(boolean [] [] adj, int startNode, int totalNodes,  boolean [] visited) {

        visited[startNode] = true;
        int nCount = 0;

        for(int i = 0; i<totalNodes; i++)
            if(adj[startNode][i] && !visited[i])
                nCount += fillNeighCount(adj, i, totalNodes, visited);

        if((nCount + 1) % 2 == 0) removedEdges++;

        return nCount + 1;
    }

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)))
        {
            boolean [] [] adj = new boolean [MAX_N][MAX_N];
            boolean [] visited = new boolean[MAX_N];

            String [] line = bf.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int i, j;

            while (m-- > 0) {
                line = bf.readLine().split(" ");
                i = Integer.parseInt(line[0]) - 1;
                j = Integer.parseInt(line[1]) - 1;
                adj[i][j] = true; adj[j][i] = true;
            }

            fillNeighCount(adj, 0, n, visited);

            System.out.println(removedEdges-1);

        } catch(IOException e) {}
    }
}
