import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            int n = Integer.parseInt(bf.readLine());
            String [] line = bf.readLine().split(" ");
            int [] arr = new int [n];
            int i, swaps;
            int swap0 = 0;
            int swap1 = 0;
            int rev0 = 0;
            int rev1 = 0;

            for(i = 0; i<n; i++)
                arr[i] = Integer.parseInt(line[i]);

            swaps = 0;
            for(i = 1; i<n; i++) {
                if(arr[i] < arr[i-1]) {
                    if(swaps == 0) {swap0 = i-1; swaps++;}
                    else if(swaps == 1) {swap1 = i; swaps++;}
                    else {swaps++; break;}
                }
            }

            switch(swaps) {
                case 0:
                    System.out.println("yes");
                    break;

                case 1:
                    swap1 = swap0+1;
                case 2:
                    boolean condition = arr[swap1] <= arr[swap0+1];
                    if(swap0 >= 1) condition &= arr[swap0-1] < arr[swap1];
                    condition &= arr[swap1-1] <= arr[swap0];
                    if(swap1 < n-1) condition &= arr[swap0] < arr[swap1+1];
                    if(condition) {
                        System.out.println("yes");
                        System.out.printf("swap %d %d%n", swap0+1, swap1+1);
                    } else
                        System.out.println("no");
                    break;

                default:
                    boolean reversing = false;
                    boolean nomore = false;
                    for(i = 1; i<n; i++)
                        if(arr[i] < arr[i-1]) {
                            if(nomore) {
                                System.out.println("no");
                                System.exit(0);
                            }
                            if(!reversing) {
                                reversing = true;
                                rev0 = i-1;
                            }
                        } else {
                            if(reversing) {
                                reversing = false;
                                rev1 = i-1;
                                nomore = true;
                            }
                        }

                    if(reversing) rev1 = arr.length-1;

                    condition = true;
                    if(rev0 >= 1) condition &= arr[rev0-1] < arr[rev1];
                    if(rev1 < n-1) condition &= arr[rev0] < arr[rev1+1];
                    if(condition) {
                        System.out.println("yes");
                        System.out.printf("reverse %d %d%n", rev0+1, rev1+1);
                    } else {
                        System.out.println("no");
                    }
            }


        } catch(IOException e) {}
    }
}
