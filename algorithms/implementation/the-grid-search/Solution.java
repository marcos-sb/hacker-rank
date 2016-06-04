import java.io.*;
import java.util.*;

public class Solution {

    private static boolean find(String [] pat, String [] mat) {
        int n = mat.length;
        int m = mat[0].length();
        int np = pat.length;
        int mp = pat[0].length();
        boolean replace = false;

        for(int i = 0; i<=n-np; i++)
            for(int j = 0; j<=m-mp; j++)
                if(mat[i].charAt(j) == pat[0].charAt(0)) {
                    replace = false;
                    for(int k = 0; k<np; k++) {
                        for(int l = 0; l<mp; l++) {
                            if(mat[i+k].charAt(j+l) != pat[k].charAt(l)) {
                                replace = true;
                                break;
                            }
                        }
                        if(replace) break;
                    }
                    if(!replace) return true;
                }
        return false;
    }

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            int t = Integer.parseInt(bf.readLine());
            int n,m,np,mp, i,j;
            String [] line;
            String [] mat, pat;

            while(t-- > 0) {
                line = bf.readLine().split(" ");
                n = Integer.parseInt(line[0]);
                m = Integer.parseInt(line[1]);
                mat = new String [n];
                for(i = 0; i<n; i++)
                    mat[i] = bf.readLine();

                line = bf.readLine().split(" ");
                np = Integer.parseInt(line[0]);
                mp = Integer.parseInt(line[1]);
                pat = new String [np];
                for(i = 0; i<np; i++)
                    pat[i] = bf.readLine();

                if(find(pat, mat))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }

        } catch(IOException e) {}
    }
}
