package com.zoubi.producerconsumer;

import java.util.List;

public class Consumer implements Runnable{
	
	List<Integer> questionList = null;
	
	final int LIMIT = 5; 
	private int questionNo;

	
	public Consumer(List<Integer> questionList) {
		this.questionList = questionList;
	}
	
	public void answerQuestion() throws InterruptedException {
		
		synchronized(questionList) {
			while (questionList.isEmpty()) {
				System.out.println("No questions to answer... waiting for Producer to get questions");
				questionList.wait(); //waits in order to pass control to another thread
			}
		}
		
		synchronized (questionList) {
			Thread.sleep(5000);
			System.out.println("Answered question: " + questionNo + questionList.remove(0)); //remove also prints the removed item/question
			questionList.notify(); //this will notify the thread that was waiting that a question was answered
			
			//*** if you use concurrent packages you don't need to use wait and notify methods anymore which is the best practice ***
		}
	}

	
	
	@Override
	public void run() {

		while(true) {
			try {
				answerQuestion();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		
	}


}
