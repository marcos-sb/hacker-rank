
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Solution {

    public static void main(String [] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            Pattern p = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})(AM|PM)");
            Matcher m = p.matcher(bf.readLine().trim());
            if(m.matches()) {
                boolean am = "AM".equals(m.group(4));

                String h;
                if("12".equals(m.group(1))) {
                    h = am ? "00" : "12";
                } else if(am) {
                    h = m.group(1);
                } else {
                    h = String.valueOf(Integer.parseInt(m.group(1)) + 12);
                }

                System.out.printf("%s:%s:%s",h,m.group(2),m.group(3));
            }

        } catch(IOException e) {}
    }
}
