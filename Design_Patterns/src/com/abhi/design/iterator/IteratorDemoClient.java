package com.abhi.design.iterator;

public class IteratorDemoClient 
{
	public static void main(String[] args) 
	{
		CollectionOfNames collection = new CollectionOfNames();

		for (Iterator iter = collection.getIterator(); iter.hasNext();) 
		{
			String name = (String) iter.next();
			System.out.println("Name : " + name);
		}

	}

}
