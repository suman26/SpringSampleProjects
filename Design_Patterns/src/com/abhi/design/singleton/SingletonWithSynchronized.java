/* 
 * This will work fine in mutlithreaded enviornment but it is quite increase overhead as it is blocking the whole 
 * process .
 * 
 * 
 * 
 * */
package com.abhi.design.singleton;

public class SingletonWithSynchronized {
	private static SingletonWithSynchronized instance;
	
	private SingletonWithSynchronized()
	{	
	}
	public static synchronized SingletonWithSynchronized getInstance(){
		if(instance==null)
		{
		 instance=new SingletonWithSynchronized();
		}
		return instance;
	}

}
