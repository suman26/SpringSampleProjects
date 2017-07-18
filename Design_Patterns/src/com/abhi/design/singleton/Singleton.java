//This will work in single threaded enviornment....
//It wont work in Multithreaded and create multiple instances of it ....
package com.abhi.design.singleton;

public class Singleton {

	private static Singleton instance;
	
	private Singleton()
	{
		
	}
	public static Singleton getInstance()
	{
		if(instance==null)
		{
			instance=new Singleton();
		}
		return instance;
	}
	public void showMessage()
	{
		System.out.println("Hello World by Singleton class");
	}
	public static void main(String[] args) {
		Singleton s=Singleton.getInstance();
		s.showMessage();
		
	}
}
