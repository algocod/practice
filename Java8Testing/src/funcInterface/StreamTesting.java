package funcInterface;

import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTesting {

	public static void main(String[] args) {

		Integer[] iAr = new Integer[]{1,2,3,4,5,6,7,8,9};
		Stream<Integer> stream = Stream.of( iAr);
		// Average
		OptionalDouble db = stream.mapToInt(i -> i).average();
		if(db.isPresent())
			db.getAsDouble();
        List<Integer> aL = stream.filter(p -> p%2==0).collect(Collectors.toList());
        stream.close();
        //Stream<List<Integer>> stream2 = Stream.of( aL); Diff ways of streaming
        // Get a stream of List<Integer> or Stream of <Integer> directly
        Stream<Integer> stream2 = aL.stream();
        stream2.forEach(p -> System.out.println(p));
        
        // No Stream objects in arrays, only on COllections 
        Integer[] divArr = aL.stream().filter(i -> i%4 == 0).toArray(Integer[]::new);
        System.out.print(divArr.toString());
        
        //Infinite live date printing
        Stream<Date> stream3 = Stream.generate(() -> { return new Date();});
        //stream3.forEach(p -> System.out.println(p));
        
        Stream<String> stream4 = Stream.of("A$B$C".split("\\$"));
        stream4.forEach(p -> System.out.println(p));
        
	}

}
