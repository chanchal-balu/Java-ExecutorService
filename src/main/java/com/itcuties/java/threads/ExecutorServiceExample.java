package com.itcuties.java.threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService example. 
 * Waiting for threads to finish their work.
 * 
 * @author itcuties
 *
 */
public class ExecutorServiceExample {

	// Run threads
	public static void main(String[] args)  {
		System.out.println("["+System.currentTimeMillis()+"]["+Thread.currentThread().getName()+"]:: starting");
		
		// Executor service that can execute up to 5 threads
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for (int i=0; i < 10; i++) {
			Runnable thread = new Runnable() {
				// Sample thread - prints out random numbers
				public void run() {
					Random random = new Random();
					for (int i=0; i < 10; i++) {
						System.out.println("["+System.currentTimeMillis()+"]["+Thread.currentThread().getName()+"]:: lucky numer is " + random.nextInt(10000));
					}
				}};
				
			
			executor.execute(thread);
			
		}
		
		// Accept no more new threads
		executor.shutdown();
		
		// Waiting for all the threads to finish
		while(!executor.isTerminated()) {
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("["+System.currentTimeMillis()+"]["+Thread.currentThread().getName()+"]:: done");
		
	}
	
}
