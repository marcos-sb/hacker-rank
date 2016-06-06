import java.io.*;
import java.util.*;

public class Solution {

    private static void swap(int i, int j, int [] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            String [] line = bf.readLine().trim().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            int i;

            line = bf.readLine().trim().split(" ");
            int [] arr = new int [n];
            for(i=0; i<n; i++)
                arr[i] = Integer.parseInt(line[i]);

            int max;
            for(int _case = 0; _case < k && _case < n; _case++) {
                max = n - _case;
                for(i=_case; i<n; i++) if(arr[i] == max) break;
                if(i == _case) k++;
                else swap(_case, i, arr);
            }

            for(Integer _int : arr)
                System.out.print(_int+" ");

        } catch(IOException e) {}
    }
}
