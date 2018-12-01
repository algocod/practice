package algorithms.strings;

import java.util.Arrays;

public class SubstringIndexPractice {

	public static void main(String[] args) {
		String input = "cbade  as";
		char[] arr = input.toCharArray();
		System.out.println(input.length());
		System.out.println(input.substring(0,1));
		System.out.println(input.substring(1,5)); // substring takes input of array like index but it doesnt include the end index hence you can put the length as well
		Arrays.sort(arr);
		System.out.println(arr);
		for(int i =0;i<input.length();i++)
		{
			System.out.println(Character.isLetterOrDigit(input.charAt(i)));
		}
		
		int head = 0;
		int tail = input.length()-1;
		while(head<=tail)
		{
			System.out.println(head+"---"+tail);
			System.out.println(input.charAt(head));
			System.out.println(input.charAt(tail));
			System.out.println(input.charAt(tail)==input.charAt(head));
			head++;
			tail--;
		}
		
	}

}
