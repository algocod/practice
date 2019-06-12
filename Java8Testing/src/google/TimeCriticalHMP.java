package google;
/**
 * You have to implement a time critical hashmap, such that you are given input as: key, value & time-limit. If the time limit gets over and then the hashmap must not return any value. 
This should be strictly implemented as an Object Oriented code.
Key learnings from this problem is when to do a time check and when to remove , they all should be single line code statements. 
Probably write a get method where the timestamp is checked and returned else removed. 
 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.TimeZone;

public class TimeCriticalHMP {

	public static void main(String[] args) {
		
		HashMap<Integer,KeyWithTime> hmp = new HashMap<>();
		
		int ex = 20;
		while(ex>0)
		{
			KeyWithTime temp = new KeyWithTime(ex, 1000*ex*5);
			hmp.put(ex,temp);
			ex--;
		}
		while(true)
		{
		Scanner input = new Scanner(System.in);
		int entry = input.nextInt();
		KeyWithTime ret = hmp.get(entry);
		System.out.println(System.currentTimeMillis()-ret.start<ret.limit);
		System.out.println(ret.isValid); // the boolean in hte object is NOT evaluated everytime.
		KeyWithTime toret = System.currentTimeMillis()-hmp.get(entry).start<hmp.get(entry).limit?hmp.get(entry):null;
		KeyWithTime ret1 = hmp.get(entry)!=null?hmp.get(entry).isValid?hmp.get(entry):null:null;
		// hmp.remove 
		System.out.println(ret!=null?ret.k:"Expired element");
		}
	}
	
	static class KeyWithTime
	{
		public int k = 0;
		public long start = System.currentTimeMillis();
		public long limit = 0;
		boolean isValid = System.currentTimeMillis()-start<limit;
		
		KeyWithTime(int ke, long l)
		{
			k = ke;
			limit =l;
		}
	}

}
