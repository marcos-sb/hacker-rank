import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Solution {

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {
            final Pattern idNumber = Pattern.compile("^[a-z]{0,3}\\d{2,8}[A-Z]{3,}$");
            Matcher m;
            final int n = Integer.parseInt(bf.readLine());
            for(int i = 0; i<n; i++) {
                m = idNumber.matcher(bf.readLine());
                if(m.matches()) System.out.println("VALID");
                else System.out.println("INVALID");
            }

        } catch (IOException ex) {}
    }
}
