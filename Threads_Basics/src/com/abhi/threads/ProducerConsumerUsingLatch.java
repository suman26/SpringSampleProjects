package com.abhi.threads;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

public class ProducerConsumerUsingLatch {

	public static void main(String[] args) {
     CountDownLatch latch=new CountDownLatch(1);
     LinkedList<Integer> queue=new LinkedList<Integer>();
     Thread p= new Thread(new ProducerLatch(latch,queue));
     Thread c=new Thread(new ConsumerLatch(latch,queue));
     p.start();
     c.start();
	}
}

class ProducerLatch implements Runnable {

	CountDownLatch latch;
	LinkedList<Integer> queue;

	public ProducerLatch(CountDownLatch latch, LinkedList<Integer> queue) {
		super();
		this.latch = latch;
		this.queue = queue;
	}

	@Override
	public void run() {
		int next = 0;
		while (true) {
			synchronized (queue) {
				queue.add(next);
				latch.countDown();
			}
			next++;
		}

	}

}

class ConsumerLatch implements Runnable {
	CountDownLatch latch;
	LinkedList<Integer> queue;

	public ConsumerLatch(CountDownLatch latch, LinkedList<Integer> queue) {
		super();
		this.latch = latch;
		this.queue = queue;
	}

	@Override
	public void run() {

		while (true) {
			Integer number = null;
			synchronized (queue) {
				if (queue.size() > 0) {
					number = queue.remove(queue.size() - 1);
					System.out.println("number is :" + number);
				}
			}

			if (number == null) {
				try {
					latch.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
