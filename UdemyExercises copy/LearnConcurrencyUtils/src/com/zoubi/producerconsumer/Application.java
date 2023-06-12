package com.zoubi.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Application {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5); 
		//arrayblockingqueue takes in an argument "capacity" representing the capacity of the array
		
		Thread t1 = new Thread(new Producer(questionQueue));
		
		Thread t2 = new Thread(new Consumer(questionQueue));
		
		t1.start();
		t2.start();
		

	}

}
