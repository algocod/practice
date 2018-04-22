package funcInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrentStreamOps {

	public static void main(String[] args) {

		//List<Integer>  lInt = new CopyOnWriteArrayList<Integer>();		// works with paralle stream
		List<Integer>  lInt = new ArrayList<Integer>();
		lInt.add(11);
		lInt.add(22);
		lInt.add(33);
		lInt.add(44);
		lInt.add(55);
		lInt.add(66);
	
		// Streams can be generated off Collections object while iteration goes but need to check in parallel 
		
		// Test Thread Safety on streams later
		// parallel,sorted, distinct,peek, remove while streaming etc
		
		Stream<Integer> stmInt = lInt.stream();
		List<Integer> onFilterList = stmInt.filter((i->i%2==0)).collect(Collectors.toList());
		Stream<Integer> stmInt2 = lInt.stream();
		Optional<Integer> onReduceList = stmInt2.reduce((p,n) -> p+n);
		
		System.out.println(onFilterList.toString());
		//System.out::println onReduceList;
		System.out.println(onReduceList); // Its more of a sum/overall function involving all inputs
			Iterator itr = lInt.iterator();
			while( itr.hasNext())
			{
				Integer i = (Integer)itr.next();
				i++;
				//System.out.println(i);
				//lInt.add(i);
			}
		System.out.println(lInt.toString());
		
		//Stream<Integer> stmInt3 = lInt.stream();
		//stmInt3.peek(lInt::remove).forEach(System.out::println); 
		// DONT change backing collection while streaming operations , ConCu Ex + Unexpected results
		
		Stream<Integer> stmInt4 = lInt.stream();
		Stream<Integer> stmInt5 = stmInt4.parallel() ;
		stmInt4.skip(3).forEach(System.out::println);
		stmInt5.distinct().limit(4).forEach(System.out::println);
		
		
	}

}
