
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String [] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(bf.readLine());
            while(t-- > 0) {
                String s = bf.readLine().trim();
                int i = 0;
                int j = s.length()-1;
                int mem = -1;

                while(i < j) {
                    if(s.charAt(i) == s.charAt(j)) {
                        i++; j--;
                    } else {
                        if(mem == -1) {
                            mem = i;
                            i++;
                        } else {
                            mem = s.length()-mem-1;
                            break;
                        }
                    }
                }
                System.out.println(mem);
            }
        } catch(IOException e) {}
    }
}
