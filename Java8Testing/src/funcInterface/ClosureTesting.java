package funcInterface;

import java.util.function.Function;

/**
 * This class is an example of Functional Interface method in java itself called Function that takes one arg and returns one.
 * One single method in it called apply.
 * @author hemant
 *
 */
public class ClosureTesting {

	    public Function<Integer, Integer> make_fun() {
	        // Outside the scope of the returned function:
	        int n = 0;
	        return arg -> {
	            System.out.print(n + " " + arg + ": ");
	            arg += 1;
	            // n += arg; // Produces error message
	            return n + arg;
	        };
	    }
	    public void try_it() {
	        Function<Integer, Integer> x = make_fun(), y = make_fun();
	        for(int i = 0; i < 5; i++)
	            System.out.println(x.apply(i));
	        for(int i = 10; i < 15; i++)
	            System.out.println(y.apply(i));
	    }
	    public static void main(String[] args) {
	        new ClosureTesting().try_it();
	    }

}
