package com.abhi.threads;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {

	final static ProduceConsume pc = new ProduceConsume();

	public static void main(String[] args) throws InterruptedException {

		Thread p = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		Thread c = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		});
		p.start();
		c.start();
		p.join();
		c.join();
	}

}

class ProduceConsume {
	List<Integer> buffer = new LinkedList<Integer>();
	int capacity = 2;

	public void produce() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (buffer.size() == capacity) {
					this.wait();
				}
				System.out.println("Producer added one to buffer");
				buffer.add(1);
				this.notify();
				Thread.sleep(500);
			}
		}

	}

	public void consume() throws InterruptedException {

		while (true) {
			synchronized (this) {
				if (buffer.size() == 0)
					this.wait();
				System.out.println("Consumer has consumed one from buffer");
				buffer.remove(0);
				this.notify();
				Thread.sleep(1000);
			}
		}
	}

}