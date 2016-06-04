
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(bf.readLine().trim());
            String s = bf.readLine().trim();
            int k = Integer.parseInt(bf.readLine().trim());

            StringBuilder sb = new StringBuilder(n);

            for(int i = 0; i<n; i++)
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                    sb.append((char)((s.charAt(i)-'A' + k) % ('Z'-'A'+1) + 'A'));
                else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    sb.append((char)((s.charAt(i)-'a' + k) % ('z'-'a'+1) + 'a'));
                else
                    sb.append(s.charAt(i));

            System.out.println(sb);

        } catch(IOException e) {}
    }
}
