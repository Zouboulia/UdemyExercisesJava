package com.zoubi.threading;

public class Application {

	public static void main(String[] args) {
		
		//this is the thread to print the below numbers in the for loop. 
		//thread starts running but even though it is read first, while the for loop is read 
		//the Hello there is printed and the loop is still running. Loop is printed later, when it's ready
		
		System.out.println("Starting thread 1");		
		
		
		Task taskRunner = new Task("Thread - A");
		taskRunner.start();
		
		System.out.println("Starting thread 2");
		
		Task taskRunner2 = new Task("Thread - B");
		taskRunner2.start();		
		

	}

}

class Task extends Thread {
	
	String name; 
		
	public Task(String name) {
		this.name = name;
	}

	public void run() {
		Thread.currentThread().setName(this.name);
		for(int i= 0; i<1000; i++) {
			System.out.println ("number" + i + " - " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



