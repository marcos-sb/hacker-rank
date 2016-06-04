
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(bf.readLine());
            String [] line;
            int [] arr = new int [n];
            line = bf.readLine().split(" ");
            for(int i = 0; i<n; i++)
                arr[i] = Integer.parseInt(line[i]);
            long sum = 0l;
            for(int m : arr)
                sum += m;
            System.out.println(sum);

        } catch(IOException e) {}
    }
}
