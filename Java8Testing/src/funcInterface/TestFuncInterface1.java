package funcInterface;

@FunctionalInterface
public interface TestFuncInterface1 {
	
		public void firstWork(); // Only one abstract method for a functional interface
		default void doSomeMoreWork1() // YOu can have a default method though
		{
		
		}
		default void doSomeMoreWork2(){
		}

		@Override
		public String toString();   // can add abstract method overriding from Object
}
