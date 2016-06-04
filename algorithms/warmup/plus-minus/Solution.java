
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(bf.readLine().trim());
            String [] line = bf.readLine().trim().split(" ");
            int [] arr = new int [n];

            for(int i = 0; i<n; i++)
                arr[i] = Integer.parseInt(line[i]);

            int countPos = 0;
            int countNeg = 0;
            int countZero = 0;
            for(int i : arr)
                if(i > 0) countPos++;
                else if(i < 0) countNeg++;
                else countZero++;

            float length = (float) arr.length;
            System.out.printf("%4.3f%n", countPos / length);
            System.out.printf("%4.3f%n", countNeg / length);
            System.out.printf("%4.3f%n", countZero / length);

        } catch(IOException e) {}
    }
}
