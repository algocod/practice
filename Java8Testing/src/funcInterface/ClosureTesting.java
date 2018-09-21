package funcInterface;

import java.util.function.Function;

/**
 * This class is an example of Functional Interface method in java itself called Function that takes one arg and returns one.
 * One single method in it called apply.
 * @author hemant
 *
 */
public class ClosureTesting {

		/*
		 * The parameterized type below as in Integer,Integer declares the input and return type for the function. Hence you will see Integer being called from apply()
		 * and the return type is also Integer as in n+arg .
		 */
	    public Function<Integer, Integer> make_fun() {
	        // Outside the scope of the returned function:
	        int n = 0;
	        return arg -> {
	            System.out.print(n + " " + arg + ": ");
	            arg += 1;
	             //n += arg; // Produces error message that n should be final.
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
	        System.out.println(convNumbers().apply("23"));
	        //convNumbers().andThen
	    }
	    
	    public static Function<String,Integer> convNumbers()
	    {
	    	//The below statement takes and input and then returns an output of Type Integer and that is what is the return function type of the method.
	    	//return ()-> {return 2;}; this wont work as input needs to be INteger.
	    	return abc -> {return Integer.parseInt(abc);}; // 
	    }
	    
	    public static Function<Integer,Double> tryThenFunc()
	    {
	    	Function<Integer,Double> fnT  = abc->{return abc*2.0;};
	    	return fnT;
	    	//return input -> {return input*2;};
	    }

}
