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
		
	}

	
	public static void walker(Walkable walkableEntity) {
		walkableEntity.walk();
		
	}
}
