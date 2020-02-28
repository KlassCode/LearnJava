package com.javaworks.klasscode.multithreading;

public class App {

	private static int counter = 0;

	public synchronized static void increment() {
		counter++;
	}
	
	public synchronized static void doOperation() {
		System.out.println("Affichage des nombres pairs compris entre 0 et 100");
		for(int i=0;i<100;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					increment();
					System.out.println("Thread --> "+ Thread.currentThread().getId()+" counter "+ counter);
				}
			}
		});
		
		Thread tOperation= new Thread(new Runnable() {
			@Override
			public void run() {
				doOperation();
			}
		});
//		Thread t2 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 100; i++) {
//					increment();
//					System.out.println("Thread --> "+ Thread.currentThread().getId()+" counter "+ counter);
//				}
//			}
//		});
		
		

		t1.start();
		tOperation.start();
		//t2.start();

		try {
			t1.join();
			//t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("counter " + counter);
	}

}
