
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(bf.readLine().trim());
            String [] line;
            int [][] mat = new int [n][n];
            for(int i = 0; i<n; i++) {
                line = bf.readLine().trim().split(" ");
                for(int j = 0; j<n; j++)
                    mat[i][j] = Integer.parseInt(line[j]);
            }

            int sumD = 0; int sumU = 0;
            for(int i = 0; i<n; i++)
                sumD += mat[i][i];
            for(int i = n-1; i>=0; i--)
                sumU += mat[i][n-i-1];

            System.out.println(Math.abs(sumD - sumU));

        } catch(IOException e) {}
    }
}
