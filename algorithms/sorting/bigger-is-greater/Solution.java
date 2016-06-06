import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            int t = Integer.parseInt(bf.readLine());
            String line;
            StringBuilder newWord;
            char [] toSort;
            while(t-- > 0) {
                line = bf.readLine().trim();
                if(line.length() <= 1) {
                    System.out.println("no answer");
                    continue;
                }

                newWord = new StringBuilder(line.length());
                boolean swapped = false;
                for(int i = line.length()-1; i>0; i--) {
                    if(line.charAt(i) > line.charAt(i-1)) {
                        swapped = true;
                        for(int j = 0; j < i-1; j++)
                            newWord.append(line.charAt(j));

                        toSort = new char [line.length()-i];
                        int k = 0;
                        for(int j = i; j<line.length(); j++)
                            toSort[k++] = line.charAt(j);
                        Arrays.sort(toSort);

                        char pivot = line.charAt(i-1);
                        char newPivot = line.charAt(i);
                        for(int j =0; j < toSort.length; j++)
                            if(pivot < toSort[j]) {
                                newPivot = toSort[j];
                                toSort[j] = pivot;
                                break;
                            }

                        newWord.append(newPivot).append(toSort);
                        System.out.println(newWord);
                        break;
                    }
                }
                if(!swapped) {
                    System.out.println("no answer");
                }
            }

        } catch(IOException e) {}
    }
}
