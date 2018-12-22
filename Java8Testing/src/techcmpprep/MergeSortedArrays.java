package techcmpprep;

import java.util.Stack;

public class MergeSortedArrays {

	public static void main(String[] args) {
		int [] arr1 = {1,2,3,0,0,0};
		int [] arr2 = {2,5,6};
		merge(arr1, 3, arr2, 3);
		System.out.println(arr1);

	}
	
	public static void merge(int A[], int m, int B[], int n) {
	        int i=m-1;
			int j=n-1;
			int k = m+n-1;
			while(i >=0 && j>=0)
			{
				if(A[i] > B[j])
					A[k--] = A[i--];
				else
					A[k--] = B[j--];
			}
			while(j>=0)
				A[k--] = B[j--];
	    }
}
