package com.javaworks.klasscode.multithreading;

class Processor {

	public synchronized void waitingMethod() {

		Thread t = Thread.currentThread();
		System.out.println(t.getName() + " " + " is releasing to locK and going to wait ....");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// This is where the thread continue when notify is called

		System.out.println(t.getName() + " got the object lock back and continue is execution");
	}

	public synchronized void sleepingMethod() {
		Thread t2 = Thread.currentThread();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notify();

		System.out.println("A thread god the object lock back from " + t2.getName());
	}
}

public class UseOfWaitNotify {

	public static void main(String[] args) {

		Processor p = new Processor();
		

		Thread first = new Thread(new Runnable() {

			@Override
			public void run() {

				p.waitingMethod();

			}

		});

		Thread second = new Thread(new Runnable() {

			@Override
			public void run() {

				// Processor p2 = new Processor();
				p.sleepingMethod();

			}

		});
		
		first.start();
		second.start();
	}

}
