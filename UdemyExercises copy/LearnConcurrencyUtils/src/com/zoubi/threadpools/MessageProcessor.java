package com.zoubi.threadpools;

public class MessageProcessor implements Runnable{
	
	private int message;
	
	public MessageProcessor(int message) {
		
		this.message = message;
	}
	

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " [RECEIVED MESSAGE] = " + message);
		respondToMessage(); //make thread sleep to simulate doing some work
		
		System.out.println(Thread.currentThread().getName() + " (DONE) Processing Message " + message);
		
	}
	
	private void respondToMessage() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Unable to process message " + message);
		}
	}

}
