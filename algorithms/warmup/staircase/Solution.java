
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(bf.readLine());
            for(int i = 1; i<=n; i++) {
                for(int j = 0; j<n-i; j++)
                    System.out.print(" ");
                for(int j = i; j>0; j--)
                    System.out.print("#");
                System.out.println();
            }
        } catch(IOException e) {}
    }
}
