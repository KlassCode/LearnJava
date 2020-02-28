package com.javaworks.klasscode.multithreading;

class ShowNumbers {

	public void printNumbers(int n) {

		synchronized (this) {

			for (int i = 1; i <= n; i++) {
				System.out.println(i * n);
			}
		}

	}
}

public class SynchronizedBlock {

	public static void main(String[] args) {

		Thread t1 = new Runner1(new ShowNumbers());
		Thread t2 = new Runner2(new ShowNumbers());

		t1.start();
		t2.start();
	}
}

class Runner1 extends Thread {

	private ShowNumbers shownumbers;

	public Runner1(ShowNumbers showNumbers) {
		this.shownumbers = showNumbers;
	}

	@Override
	public void run() {
		shownumbers.printNumbers(5);
	}
}

class Runner2 extends Thread {

	private ShowNumbers shownumbers;

	public Runner2(ShowNumbers showNumbers) {
		this.shownumbers = showNumbers;
	}

	@Override
	public void run() {
		shownumbers.printNumbers(10);
	}
}