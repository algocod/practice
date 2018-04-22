package algorithms.sort;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
/**
 * This class sorts the String representation of Integers using String comparison. First compares length and then the normal string compareTo whihc takes care of numeric
 * order
 Input:
6
31415926535897932384626433832795
1
3
10
3
5

Output:
1
3
3
5
10
31415926535897932384626433832795
 * @author hemant
 *
 */
public class StringNumbersSorting {
	
	    void solve(Scanner in, PrintWriter out) {
	        String a[] = new String[in.nextInt()];
	        for (int i = 0; i < a.length; i++) {
	            a[i] = in.next();
	        }
	        // Writing a Comparator in a Lambda function 
	        Arrays.sort(a, (left, right) -> {
	            if (left.length() != right.length()) {
	                return left.length() - right.length();
	            } else {
	                return left.compareTo(right);
	            }
	        });
	        for (String s : a) {
	            out.println(s);
	        }
	    }
	    
	    void run() {
	        try (
	            Scanner in = new Scanner(System.in);
	            PrintWriter out = new PrintWriter(System.out);
	        ) {
	            solve(in, out);
	        }
	    }

	    public static void main(String args[]) {
	        new StringNumbersSorting().run();
	    }
	
}
