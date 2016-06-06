
import java.util.*;

public class Solution {

    private static void printArr(int [] arr) {
        for(int n : arr)
            System.out.print(n+" ");
        System.out.println();
    }

    private static int partition(int [] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo-1;
        int temp;

        for(int j = lo; j < hi; j++)
            if(arr[j] <= pivot) {
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        arr[hi] = arr[i+1];
        arr[i+1] = pivot;

        return i+1;
    }

    private static void qsort(int [] arr, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(arr, lo, hi);
        printArr(arr);
        qsort(arr, lo, j-1);
        qsort(arr, j+1, hi);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [n];

        for(int i = 0; i<n; i++)
            arr[i] = sc.nextInt();

        qsort(arr, 0, arr.length-1);
    }
}
