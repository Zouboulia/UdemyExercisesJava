package lambda_practice;

public class App {
	
	public static void main(String [] args) {
		
		Human tom = new Human();
		//walker(tom);
		
		Robot wale = new Robot();
		//walker(wale);
		
		//Can create new instance of the interface
		/* walker(new Walkable() {

			@Override
			public void walk() {
				System.out.println("Custom object walking");
				
			}
			
		}); */
		
		//converting the above code to lamda expression since Java 8: 
		/* walker( () -> {
			System.out.println("Custom object walking");
			System.out.println("The object tripped");
			
		});//if only one line of execution, curly braces not needed but if multiple actions then they are needed.
		*/
		
		walker( () -> System.out.println("Custom object walking"));
		
		// now let's see how to assign it to a variable instead: (need to create a class to assign a type to this variable
		ALambdaInterface aBlockOfCode = () -> {
			System.out.println("Custom object walking");
			System.out.println("The object tripped");
			};
			
		//the type of Lambda expressions MUST BE a functional interface (interface with ONLY ONE abstract method in it)
			
			
			ALambdaInterface helloVar = () -> System.out.println("Hello There!");
			
			
			Calculate sumVar = (a , b) -> a + b;
			helloVar.someMethod();
			System.out.println(sumVar.compute(5, 5));
			
			Calculate nonZeroDivider = (a,b) -> {
				if(a ==0) {
					return 0;
				}
				return a/b;
			};
			
			System.out.println(nonZeroDivider.compute(10, 2));
			
			//make the reverse method into Lambda 
			StringWorker reverser = (s) -> {
				String result = "";
				for (int i = s.length() - 1; i >= 0 ; i--) {
					result = result + s.charAt(i);
				}
				return result;
			};
			
			System.out.println(reverser.work("vehicle"));
			
			
			
			//factorial into Lambda expression: 
			NumberWorker computedNumber = (n)-> {
				int result = 1; 
				for(int i = 1; i <= n; i++) {
					result = i * result; 
				}
				return result; 
			};
			
			System.out.println(computedNumber.compute(10));
			
		
	}//main
	

	
	public static void walker(Walkable walkableEntity) {
		walkableEntity.walk();
		
	}
	
	public void sayHello() {
		System.out.println("Hello There!");
	}

	
	public int sum(int arg1 , int arg2) {
		return arg1 + arg2;
	}
	
	
	public int nonZeroDivider(int arg1 , int arg2) {
		if(arg1 ==0) {
			return 0;
		}
		return arg1 / arg2 ;
		
	}
	
	public String reverse(String str) {
		String result = "";
		for (int i = str.length() - 1; i >= 0 ; i--) {
			result = result + str.charAt(i);
		}
		return result;
	}
	
	
	public int factorial(int num) {
		int result = 1; 
		for(int i = 1; i <= num; i++) {
			result = i * result; 
		}
		return result; 
	}
	
	
	
}

//FUNCTIONAL INTERFACES
//defining an interface here (could also just create one) to sum the args above since both current interfaces are void so don't return anything, 
//Whereas sum method returns a sum of ints

interface Calculate{
	public int compute(int a, int b);
	
}

interface StringWorker{
	public String work(String str); 
}


interface NumberWorker{
	public int compute(int a);
	
}

interface MyGenericInterface <T>{
	public T work(T t);
	
}
