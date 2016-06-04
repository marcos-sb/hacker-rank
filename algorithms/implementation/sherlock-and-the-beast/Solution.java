import java.io.*;
import java.util.*;

public class Solution {

    private static StringBuilder fillWith(StringBuilder sb, char c, int count) {
        while(count-- > 0)
            sb.append(c);
        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int num;

        while(n-- > 0) {
            num = sc.nextInt();
            if(num < 3 || num == 7) {
                System.out.println("-1");
                continue;
            } else if(num % 3 == 0) {
                System.out.println(fillWith(new StringBuilder(num), '5', num));
                continue;
            } else if(num >= 5) {
                int lcm = num % 3 == 1 ? 10 : 5;
                System.out.println(fillWith(fillWith(new StringBuilder(num), '5', num - lcm), '3', lcm));
                continue;
            } else {
                System.out.println("-1");
            }
        }
    }
}
