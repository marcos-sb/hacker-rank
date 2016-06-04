import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); sc.nextLine();
        int i;
        String [] topics = new String [N];

        for(i = 0; i < N; i++) {
            topics[i] = sc.nextLine();
        }

        int unionTopic;
        int maxUnionTopic = 0;
        int mUTCount = 0;
        for(i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                unionTopic = sumOr(topics[i], topics[j]);
                if(unionTopic > maxUnionTopic) {
                    maxUnionTopic = unionTopic;
                    mUTCount = 1;
                } else if(unionTopic == maxUnionTopic)
                    mUTCount++;
            }
        }
        System.out.printf("%d%n%d", maxUnionTopic, mUTCount);
    }

    private static int sumOr(String a, String b) {
        int ones = 0;
        for(int i = 0; i < a.length(); i++)
            if(a.charAt(i) == '1' || b.charAt(i) == '1')
                ones++;
        return ones;
    }
}
