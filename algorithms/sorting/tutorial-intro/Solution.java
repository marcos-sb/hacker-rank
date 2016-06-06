import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int n = sc.nextInt();
        for(int i = 0; i<n; i++) {
            if(V == sc.nextInt()) {
                System.out.printf("%d", i);
                System.exit(0);
            }
        }
        System.out.printf("%d", -1);
    }
}
