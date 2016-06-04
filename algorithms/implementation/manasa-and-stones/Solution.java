import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a, b, n, n_a, value;
        Integer endingValue;
        PriorityQueue<Integer> endingValues = new PriorityQueue<>();
        HashSet<Integer> values = new HashSet<>();

        while(T-- > 0) {
            n = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();

            n_a = n-1; //num a's on each case

            for(int i = 0; i < n; i++) {
                value = (n_a-i) * b + i * a;
                if(!values.contains(value)) {
                    values.add(value);
                    endingValues.add(value);
                }
            }

            while((endingValue = endingValues.poll()) != null) {
                System.out.printf("%d ", endingValue);
            }
            System.out.printf("%n");
            values.clear();
        }
    }
}
