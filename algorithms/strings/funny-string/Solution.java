
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String [] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(bf.readLine());
            while(t-- > 0) {
                String s = bf.readLine().trim();

                int j = s.length()-2;
                int i = 0;
                boolean funny = true;
                while(j > i) {
                    if(Math.abs(s.charAt(i) - s.charAt(i+1)) != Math.abs(s.charAt(j) - s.charAt(j+1))) {
                        funny = false;
                        break;
                    }
                    i++; j--;
                }
                if(funny) System.out.println("Funny");
                else System.out.println("Not Funny");

            }

        } catch(IOException e) {}
    }
}
