package com.javaworks.klasscode.multithreading;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numThreads=5;
		for(int i=0;i<numThreads;i++) {
			Thread t1 = new Thread(new ThreadExample());
			t1.start();
		}
	}

}
