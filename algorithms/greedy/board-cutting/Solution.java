import java.io.*;
import java.util.*;

public class Solution {

    private static long minCost(Long [] hs, Long [] vs, long modulo) {
        int h_blocks = 0;
        int v_blocks = 0;
        int cuts = 0;
        long cost = 0; long el;

        Arrays.sort(hs, Collections.reverseOrder());
        Arrays.sort(vs, Collections.reverseOrder());

        for(int i = 0; i<hs.length+vs.length; i++) {
            if(h_blocks >= hs.length) {
                el = vs[v_blocks++]; cuts = h_blocks+1;
            }
            else if(v_blocks >= vs.length) {
                el = hs[h_blocks++]; cuts = v_blocks+1;
            }
            else if(hs[h_blocks] > vs[v_blocks]) {
                el = hs[h_blocks++]; cuts = v_blocks+1;
            }
            else if(hs[h_blocks] < vs[v_blocks]) {
                el = vs[v_blocks++]; cuts = h_blocks+1;
            }
            else if(hs[h_blocks] * v_blocks > vs[v_blocks] * h_blocks) {
                el = hs[h_blocks++]; cuts = v_blocks+1;
            }
            else if(hs[h_blocks] * v_blocks < vs[v_blocks] * h_blocks) {
                el = vs[v_blocks++]; cuts = h_blocks+1;
            }
            else if(hs.length - h_blocks > hs.length - h_blocks) {
                el = hs[h_blocks++]; cuts = v_blocks+1;
            }
            else if(hs.length - h_blocks < hs.length - h_blocks) {
                el = vs[v_blocks++]; cuts = h_blocks+1;
            }
            else {
                el = hs[h_blocks++]; cuts = v_blocks+1;
            }
            //System.out.println(el + "*" + cuts);
            cost = (el * cuts + cost) % modulo;
        }
        return cost;
    }

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            int t = Integer.parseInt(bf.readLine());
            String [] line;
            int m,n,i;
            long modulo = 1000000000 + 7;
            Long [] hs, vs;

            while(t-- > 0) {
                line = bf.readLine().split(" ");
                m = Integer.parseInt(line[0]);
                n = Integer.parseInt(line[1]);

                line = bf.readLine().split(" ");
                hs = new Long [m-1];
                for(i = 0; i<m-1; i++)
                    hs[i] = Long.parseLong(line[i]);
                line = bf.readLine().split(" ");
                vs = new Long [n-1];
                for(i = 0; i<n-1; i++)
                    vs[i] = Long.parseLong(line[i]);

                System.out.println(minCost(hs, vs, modulo));
            }

        } catch(IOException e) {}
    }
}
