import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        HashSet<Long> squares = new HashSet<>();
        long max = (long) Math.pow(10, 9);
        long n = 1, temp;
        while((temp = n*n) <= max) {
            squares.add(temp);
            n++;
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long A, B;
        long sq, i;
        int squareCount;
        while(T-- > 0) {
            squareCount = 0;
            A = sc.nextInt();
            B = sc.nextInt();
            sq = A;
            while(sq <= B) {
                if(!squares.contains(sq)) sq++;
                else { // sq is a perfect square
                    i = ((long) Math.sqrt(sq));
                    while(sq <= B) {
                        i++;
                        squareCount++;
                        sq = i*i;
                    }
                }
            }

            System.out.println(squareCount);
        }
    }
}
