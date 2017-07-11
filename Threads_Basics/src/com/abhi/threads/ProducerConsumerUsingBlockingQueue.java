package com.abhi.threads;

import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerUsingBlockingQueue {
	
	public static void main(String[] args) {
		final LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		Thread p=new Thread(new Producer(queue));
		Thread c=new Thread(new Consumer(queue));
		p.start();
		c.start();
		
	}

}

class Consumer implements Runnable
{
	LinkedBlockingQueue<Integer> queue;
	
	public Consumer(LinkedBlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i=0;i<5;i++)
		{
			try {
				System.out.println("Producer has produced item :"+i);
				queue.put(i);
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
class Producer implements Runnable
{
	

	LinkedBlockingQueue<Integer> queue;

	public Producer(LinkedBlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {

		for(int i=0;i<5;i++)
		{
			try {
				System.out.println("Consumer is consuming item :"+queue.take());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
