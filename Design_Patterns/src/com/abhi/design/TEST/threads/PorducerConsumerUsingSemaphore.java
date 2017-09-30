package com.abhi.threads;

import java.util.concurrent.Semaphore;

public class PorducerConsumerUsingSemaphore {

	private static Semaphore producerSemaphore =new Semaphore(1);
	private static Semaphore consumerSemaphore =new Semaphore(0);
	
	public static void main(String[] args) {
		Thread p=new Thread(new ProducerSemaphore(producerSemaphore,consumerSemaphore));
		Thread t=new Thread(new ConsumerSemaphore(producerSemaphore,consumerSemaphore));
		p.start();
		t.start();
	}
}
class ProducerSemaphore implements Runnable{
	private Semaphore producerSemaphore;
	private Semaphore consumerSemaphore;
	
	public ProducerSemaphore(Semaphore producerSemaphore, Semaphore consumerSemaphore) {
		super();
		this.producerSemaphore = producerSemaphore;
		this.consumerSemaphore = consumerSemaphore;
	}

	@Override
	public void run() {
		
		for(int i=0;i<5;i++)
		{
			try {
				producerSemaphore.acquire();
				System.out.println("Producer has produced item i:"+i);
				consumerSemaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class ConsumerSemaphore implements Runnable
{
	private Semaphore producerSemaphore;
	private Semaphore consumerSemaphore;

	public ConsumerSemaphore(Semaphore producerSemaphore, Semaphore consumerSemaphore) {
		super();
		this.producerSemaphore = producerSemaphore;
		this.consumerSemaphore = consumerSemaphore;
	}

	@Override
	public void run() {
		for(int i=0;i<5;i++)
		{
			try {
				consumerSemaphore.acquire();
				System.out.println("Consumer has consumed item i:"+i);
				producerSemaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}