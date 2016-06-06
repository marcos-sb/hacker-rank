import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashMap;

public class Solution {

    private static final HashMap<String, String> str2cmprsd;
    static {
        str2cmprsd = new HashMap<>();
        str2cmprsd.put("ab", "c");
        str2cmprsd.put("ba", "c");
        str2cmprsd.put("ac", "b");
        str2cmprsd.put("ca", "b");
        str2cmprsd.put("cb", "a");
        str2cmprsd.put("bc", "a");
    }

    private static String reduce(String in) {
        if(in.length() < 2) return in;

        String reduced = str2cmprsd.get(in);
        if(reduced != null) return reduced;
        if(in.length() == 2) return in;

        String reducedSub, newReduced;
        reduced = in;
        for(int i = 0; i<in.length()-1; i++) {
            reducedSub = str2cmprsd.get(in.substring(i,i+2));
            if(reducedSub != null) {
                newReduced = reduce(in.substring(0,i)+reducedSub+in.substring(i+2));
                if(newReduced.length() < reduced.length())
                    reduced = newReduced;
                if(reduced.length() <= 2) {
                    str2cmprsd.put(in, reduced);
                    return reduced;
                }
            }
        }
        str2cmprsd.put(in, reduced);

        return reduced;
    }

    public static void main(String [] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(bf.readLine().trim());
            while(t-- > 0) {
                System.out.println(reduce(bf.readLine().trim()).length());
            }

        } catch(IOException e) {}
    }
}
