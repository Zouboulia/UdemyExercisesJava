package streams.practical;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) throws IOException {
		

		IntStream
			.range(1,  10) //Note: range function doesn't include last value
			.forEach((x) -> System.out.print(x));
		System.out.println();
		
		//integer stream with skip
		IntStream
			.range(1,  10) 
			.skip(5)//skip 5 elements of the stream --> skips the first 5 elements
			.forEach((x) -> System.out.print(x));
		System.out.println();
		
		
		//integer stream with sum
		int val = IntStream
			.range(1,  5) 
			.sum();
		System.out.println(val);
		
		//Stream.of , sorted and firdFirst
		Stream.of("Hello", "Bottle", "Africa")
		.sorted()
		.findFirst() //picks the first element in that sorted stream
		.ifPresent((x) -> System.out.println(x));
		
		//Stream from Array, sort filter and print
		String [] items  = {"car", "toys", "computer", "toothpaste", "box", "pencil", "tent"};
		Stream.of(items)
			.filter((x) -> x.startsWith("t"))
			.sorted()
			.forEach(x -> System.out.print(x + ", "));
		System.out.println();
		
		
		//average of squares of an int array
		Arrays.stream(new int [] {2 ,4 ,6 ,8 ,10})
			.map((x) -> x * x)
			.average()
			.ifPresent(n -> System.out.println(n));
		System.out.println();
		
		//Streaming files 
		Stream<String> lines = Files.lines(Paths.get("Files/wordFile.txt"));
		lines.sorted()
			.filter(l -> l.length()>6)
			.forEach(x -> System.out.print(x + ", "));
		lines.close();
		

	}

}
