package streams;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import concurrency.Person;

public class BasicStreams 
{
	public static void main(String[] args)
	{
		// Stream of Objects WITHOUT using collections
		Stream.of("a1", "a2", "a3")
	    .findFirst()
	    .ifPresent(System.out::println);  // a1
		
		// Stream of Objects using the Arrays class , convert to a List and then the streams
		Arrays.asList("a1", "a2", "a3")
	    .stream()
	    .findFirst()
	    .ifPresent(System.out::println);  // a1
		
		// Types of Streams, Primitive streams come in like IntStream, DoubleStream etc.
		IntStream.range(1, 4)
	    .forEach(System.out::print);
		
		System.out.println(" Non terminal functions and then a terminal one");
		
		// Create a stream out of primitive int array and run some functions
		int[] iar = {1,4,7,10};
		Arrays.stream(iar).mapToObj(i->i*2+"--").forEach(System.out::print);
		long lSum = Arrays.stream(iar).mapToLong(i->i*2).sum();
		// An IntStream CANT be mapped back to IntStream again.
		IntStream str = Arrays.stream(iar);
		// str.mapToInt DOESNT WORK
		
		System.out.println(lSum);
		// Functions like FindFirst or FindAny are short ciruiting terminal operations as in they DONT return streams and neither a void.
		// Optional element is returned 
		//str.findFirst().ifPresent(i->{System.out.println(i);});
		str.findFirst().ifPresent(System.out::println);
		
		// Create some custom Objects and create a stream and mapping 
		Person p1 = new Person(30, "Helo","M" );
		Person p2 = new Person(31, "Helloo","F");
		Person p3 = new Person(32, "Helllooo","M" );
		
		//Stream strObj = Stream.of(p1,p2,"hello"); // the stream is of the highest extended class, in this case its Stream<Objects>
		Stream<Person> strObj = Stream.of(p1,p2,p3);
		
		strObj.filter(p->{ if(p.age>30) return true; else return false ;}).forEach(p->{System.out.println(p.name);});
		
		// Supplier concept 
		Supplier<Stream<Person>> sup = ()-> Stream.of(p1,p2,p3);
		System.out.println(sup.get().count());
		System.out.println(sup.get().findFirst().get().name);
		
		// Complete the Reduce, FlatMap and Collect functions. 
		
	}

}
