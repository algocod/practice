package algorithms.sort;

import java.util.Scanner;

public class QuickSort {
	
    static int[] quickSort(int[] arr) {
        int pv = arr[0];
        int[] eq = {pv};
        int[] left = new int[arr.length-1];
        int[] right = new int[arr.length-1];
        int rt = 0;
        int lt = 0;
        for(int i =1;i<arr.length;i++)
        {
            if(arr[i]>pv)
            {
                right[rt] = arr[i];
                rt++;
            }
            else if (arr[i]<pv)
            {
                left[lt] = arr[i];
                lt++;
            }
                        
        }
        
        for(int i = 0;i<lt;i++)
        {
            arr[i] = left[i];
        }
        arr[lt] = pv;
        for(int i = lt+1,j=0;i<arr.length;i++,j++)
        {
            arr[i] = right[j];
        }
        
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = quickSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }

}
