package com.zoubi.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		

		//create questionlist
		List<Integer> questionList = new ArrayList<Integer>();
		
		//pass it into the Producer
		Thread t1 = new Thread(new Producer(questionList)); //producer populates/produces the questions
		Thread t2 = new Thread(new Consumer(questionList));//consumer has access to same list of questions and answers and removes questions from teh list
		
		//start the threads: 
		
		t1.start();
		t2.start();

	}

}
