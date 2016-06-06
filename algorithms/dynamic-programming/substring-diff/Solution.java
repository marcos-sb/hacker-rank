import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  private static int newDiffs(int [] startL, int [] startR, String l, String r) {

    // open a window towards the minimum diffs
    int [] lPos = {startL[0] -1, startL[1] + 1};
    int [] rPos = {startR[0] -1, startR[1] + 1};

    for(int i = 0; i<2; i++) {
      if (lPos[i] < 0 || lPos[i] >= l.length()) continue;
      if (rPos[i] < 0 || rPos[i] >= r.length()) continue;
      if (l.charAt(lPos[i]) == r.charAt(rPos[i])) {
        startL[i] = lPos[i];
        startR[i] = rPos[i];
        return 0;
      }
    }
    for(int i = 0; i<2; i++) {
      for(int j = 0; j<2; j++) {
        if (lPos[i] < 0 || lPos[i] >= l.length()) continue;
        if (lPos[j] < 0 || lPos[j] >= l.length()) continue;
        startL[i] = lPos[i];
        startR[j] = rPos[j];
        return 1;
      }
    }

    return -1;
  }

  public static void main(String [] args) {
    try (
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
    ) {

      int t = Integer.parseInt(bf.readLine());
      String [] line;
      int s, i;
      Integer counts;
      String l, r;
      HashMap<Character, Integer> charCounts;

      while(t-- > 0) {
        line = bf.readLine().split(" ");
        s = Integer.parseInt(line[0]);
        l = line[1].trim();
        r = line[2].trim();
        charCounts = new HashMap<>();

        for(i = 0; i<l.length(); i++) {
          counts = charCounts.get(l.charAt(i));
          if(counts == null) counts = 1;
          else counts++;
          charCounts.put(l.charAt(i), counts);

          counts = charCounts.get(r.charAt(i));
          if(counts == null) counts = 1;
          else counts++;
          charCounts.put(r.charAt(i), counts);
        }

        int lIndx = -1;
        int maxLen = 0;
        boolean end = false;
        boolean entered = false;

        //this code should have been wrapped into a fun
        //to 'return' instead of 'end'
        for(Map.Entry<Character,Integer> charCount : charCounts.entrySet()) {
          if (charCount.getValue() <= 1) continue; //char must be in both strings

          while ((lIndx = l.indexOf(charCount.getKey(), lIndx + 1)) != -1) {

            int rIndx = -1;
            while ((rIndx = r.indexOf(charCount.getKey(), rIndx + 1)) != -1) {

              entered = true;

              int maxLenCase = 1;
              int[] newLIndx = {lIndx, lIndx};
              int[] newRIndx = {rIndx, rIndx};
              int newDiffs;
              int diff = 0;
              while (true) {

                newDiffs = newDiffs(newLIndx, newRIndx, l, r);
                if (newDiffs == -1) {
                  maxLen = l.length();
                  end = true;
                  break;
                }

                diff += newDiffs;
                if (diff <= s)
                  maxLenCase++;
                else {
                  if (maxLen < maxLenCase)
                    maxLen = maxLenCase;
                  break;
                }
              }
              if (end) break;
            }
            if (end) break;
          }
          if(end) break;
        }

        if(!entered) maxLen = s;
        System.out.println(maxLen);
      }

    } catch(IOException e) {}

  }
}
