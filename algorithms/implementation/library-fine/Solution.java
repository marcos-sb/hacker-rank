
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            String [] line = bf.readLine().split(" ");
            int [] actual = new int [3];
            int [] expected = new int [3];
            for(int i =0; i<3; i++)
                actual[i] = Integer.parseInt(line[i]);
            line = bf.readLine().split(" ");
            for(int i =0; i<3; i++)
                expected[i] = Integer.parseInt(line[i]);

            if(actual[2] > expected[2]) {
                System.out.println("10000");
            } else if(actual[2] < expected[2]) {
                System.out.println("0");
            } else if(actual[1] > expected[1]) {
                System.out.println((actual[1] - expected[1]) * 500);
            } else if(actual[1] < expected[1]) {
                System.out.println("0");
            } else if(actual[0] > expected[0]) {
                System.out.println((actual[0] - expected[0]) * 15);
            } else if(actual[0] <= expected[0]) {
                System.out.println("0");
            }


        } catch(IOException e) {}
    }
}
