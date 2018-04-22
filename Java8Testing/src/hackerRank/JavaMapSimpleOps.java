package hackerRank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Java Map add and search ops
 * @author hemant
 *
3
uncle sam
99912222
tom
11122222
harry
12299933
uncle sam
uncle tom
harry

 */
public class JavaMapSimpleOps {

	   public static void main(String []argh)
	   {
	      Scanner in = new Scanner(System.in);
	      int n=in.nextInt();
	      in.nextLine();
	      HashMap<String,Integer> hm = new HashMap<String,Integer>();
	      for(int i=0;i<n;i++)
	      {
	         String name=in.nextLine();
	         int phone=in.nextInt();
	         hm.put(name, phone);
	         in.nextLine();
	      }
	      while(in.hasNext())
	      {
	         String s=in.nextLine();
	         if(!hm.containsKey(s))
	         {
	        	 System.out.println("Not found");
	         }
	         else
	         {
	        	 System.out.println(s+"="+hm.get(s));
	         }
	      }
	   }

}
