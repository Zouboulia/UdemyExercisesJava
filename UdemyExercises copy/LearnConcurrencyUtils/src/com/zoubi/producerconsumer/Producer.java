package com.zoubi.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	
	int questionNo;
	BlockingQueue<Integer> questionQueue;

	public Producer(BlockingQueue<Integer> questionQueue) {
		this.questionQueue = questionQueue;
	}
	
	
	@Override
	public void run() {

		while(true) {
			try {
				synchronized (this){
					//incrementing, printing and inserting into the queue in this synchronized block makes it Thread safe
					int nextQuestion = questionNo++;
					System.out.println("Got new question " + nextQuestion);
					questionQueue.put(nextQuestion);
				}
				
			} catch (InterruptedException e) {
		
			}
			
		}

	}
	

}
