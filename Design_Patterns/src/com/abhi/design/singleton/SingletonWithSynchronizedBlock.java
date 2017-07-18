/*
 * It will reduce the overhead as it does not synchronize the whole method rather it synchronize it for first time creation of instance only 
 * 
 * 
 * */
package com.abhi.design.singleton;

public class SingletonWithSynchronizedBlock {

	private static SingletonWithSynchronizedBlock instance;
	
	private SingletonWithSynchronizedBlock()
	{
	}
	public static SingletonWithSynchronizedBlock getInstance()
	{
		if(instance==null)
		{
			synchronized(SingletonWithSynchronizedBlock.class)
			{
				instance=new SingletonWithSynchronizedBlock();
			}
		}
		return instance;
	}
}
