package hackerRank;
/**
 * Find the missing number in an array of contiguous numbers
 * XOR can also be used to find non repeating characters in an array of duplicates.
 * How is a number represented as -ve in bits , take the number and take its most right bit that has value 1 , fix that value and invert the rest of bits to 0
 * @author hemant
 *
 */
public class XORPractice {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,5,6,7};
		int n = 7;
		int sumArr = 0;
		int actualSum = 0;
		
		for(Integer i : arr)
			sumArr ^=i;
		while(n>0)
		{
			actualSum ^=n;
			n--;
		}
		
		int missingNum = sumArr^actualSum;
		System.out.println(missingNum);
		
		// get last set bit from a number , lets try 7 which is 111 and then 6 110
		int p =7,k=6;
		p &=p;
		System.out.println(Integer.toBinaryString(k));//110
		System.out.println(Integer.toBinaryString(-k));//11111111111111111111111111111010
		System.out.println(Integer.toString(100, 16)); // Function to print the number to the base provided.
		k&=-k;
		System.out.println(p+"---"+k);
		
	}

}
