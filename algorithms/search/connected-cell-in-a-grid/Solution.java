import java.io.*;
import java.util.*;

public class Solution {

    private static int cellCount(int x, int y, boolean [][] visited, int [][] components) {
        if(x >= visited.length || x < 0 || y >= visited[0].length || y < 0) return 0;
        if(visited[x][y] || components[x][y] != 1) return 0;
        visited[x][y] = true;

        return 1 + cellCount(x+1,y,visited,components) +
                cellCount(x,y+1,visited,components) +
                cellCount(x+1,y+1,visited,components) +
                cellCount(x,y-1,visited,components) +
                cellCount(x+1,y-1,visited,components) +
                cellCount(x+1,y+1,visited,components) +
                cellCount(x-1,y-1,visited,components) +
                cellCount(x-1,y+1,visited,components);
    }

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(bf.readLine());
            int m = Integer.parseInt(bf.readLine());
            int [][] components = new int [n][m];
            boolean [][] visited = new boolean [n][m];

            String [] line;
            for(int i = 0; i<n; i++) {
                line = bf.readLine().split(" ");
                for(int j = 0; j<m; j++)
                    components[i][j] = Integer.parseInt(line[j]);
            }

            int maxCellCount = 0;
            for(int i = 0; i< n; i++)
                for(int j = 0; j<m; j++)
                    if(!visited[i][j] && components[i][j] == 1)
                        maxCellCount = Math.max(cellCount(i,j,visited,components), maxCellCount);

            System.out.println(maxCellCount);

        } catch(IOException e) {}
    }
}
