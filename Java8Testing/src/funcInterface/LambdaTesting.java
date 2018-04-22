package funcInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaTesting {

	public static void main(String[] args) {

		List<String> pointList = new ArrayList();
		pointList.add("1");
		pointList.add("2");
		 
		pointList.forEach(p ->  {System.out.println(p);});
		
		Integer i = 4;
		// Void lambda function
		TestFuncInterface1 eg1 = () -> {System.out.println(3*4);};
		eg1.firstWork();
		
		//Return Val lambda
		TestFuncInfRetVal intret = (x,y) -> {return x*y ;};
		System.out.println(intret.retIntVal(4, 5));
		// pass the func method as a param to a method, similar to any other object
		System.out.println(testLambdaParams(4, intret));
		//Lamba function has to be assigned to a functional Interface, e.g. PRedicate
		//int x = ()-> {System.out.println("Hello");};
		Predicate<Integer> p = x -> {return x>3;};
		System.out.println(p.test(5));
		System.out.println(p.test(2));
		
////////////////////////////////////////////////////////
		
		List<Employee> employees  = new ArrayList<Employee>();
		employees.add(new Employee("David"));
		employees.add(new Employee("Naveen"));
		employees.add(new Employee("Alex"));
		employees.add(new Employee("Richard"));
/*		
	      System.out.println("Before Sorting Names: "+Arrays.toString(employees));
	      Arrays.sort(employees, Employee::nameCompare);
	      System.out.println("After Sorting Names "+Arrays.toString(employees));
*/
	          Predicate<Employee> charIs = e-> {return e.toString().contains("ee");};
//	          System.out.print(employees);
	          System.out.print(employees.stream().filter(charIs).collect(Collectors.toList()).toString());
	          System.out.print(employees.stream().findFirst());
	          //System.out.print(employees.stream().reduce(charIs));
	          
	          // More testing on Collector Interface methods and :: syntax
}
	
	
	public static int testLambdaParams(int x, TestFuncInfRetVal intRet)
	{
		return intRet.retIntVal(2, x);
		
	}
	
	public static class Employee {
		  String name;
		  
		  Employee(String name) {
		    this.name = name;
		  }
		  
		  public static int nameCompare(Employee a1, Employee a2) {
		    return a1.name.compareTo(a2.name);
		  }
		    
		  public String toString() {
		    return name;
		  }

		}

}
