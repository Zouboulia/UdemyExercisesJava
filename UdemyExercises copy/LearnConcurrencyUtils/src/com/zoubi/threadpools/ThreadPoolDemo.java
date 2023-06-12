package com.zoubi.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
	
	public static void main(String [] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Runnable processor = new MessageProcessor(2);
		executor.execute(processor);
		
		Runnable processor3 = new MessageProcessor(3);
		executor.execute(processor3);
		
		Runnable processor4 = new MessageProcessor(4);
		executor.execute(processor4);
		
		
		executor.shutdown(); //rejects any new tasks from being submitted and gracefully shuts down the service
		
		//executor.shutdownNow(); //terminates executor immediately (not needed right now to use)
		
		
		//executor.awaitTermination can be used instead of the loop as well and you enter how long to wait
		//Hover over it to read what it does**
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//This while loop executes over itself as long as the executor is NOT terminated, it allows for last message to be printed out after executor is done
		/**while(!executor.isTerminated()) {
			
		}**/
		
		System.out.println("Submitted all tasks...");
		
	}

}
