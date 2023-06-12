package com.zoubi.producerconsumer;

import java.util.List;

public class Producer implements Runnable{
	
	List<Integer> questionList = null;
	
	final int LIMIT = 5; 
	private int questionNo;

	
	public Producer(List<Integer> questionList) {
		this.questionList = questionList;
	}
	
	public void readQuestion(int questionNo) throws InterruptedException {
		
		synchronized(questionList) {
			while (questionList.size() == LIMIT) {
				System.out.println("Questions have piled up... wait for answers");
				questionList.wait(); //waits in order to pass control to another thread
			}
		}
		
		synchronized (questionList) {
			System.out.println("New question: " + questionNo);
			questionList.add(questionNo);
			Thread.sleep(100);
			questionList.notify(); //this wakes up the threads that are waiting so they can continue processing
		}
	}

	
	
	@Override
	public void run() {

		while(true) {
			try {
				readQuestion(questionNo++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		
	}

}
