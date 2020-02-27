package com.javaworks.klasscode.multithreading;

public class ThreadExample implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread "+Thread.currentThread().getId()+" is running...");
	}
	
	
}
