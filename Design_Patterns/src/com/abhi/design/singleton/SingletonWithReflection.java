
/*
 * 
 * This handles issue with singleton class trying to create new instance using reflection ....
 * 
 * 
 * */
package com.abhi.design.singleton;

import java.lang.reflect.Constructor;

public class SingletonWithReflection {
   private static SingletonWithReflection instance;
   
   private SingletonWithReflection()
   {
	   if(instance!=null)
		   throw new InstantiationError( "Creating of this object is not allowed." );
   }
   
   public static SingletonWithReflection getInstance()
   {
	   if(instance==null)
		{
			synchronized(SingletonWithReflection.class)
			{
				instance=new SingletonWithReflection();
			}
		}
		return instance;
   }
   @SuppressWarnings({ "unchecked", "rawtypes" })
public static void main(String[] args) {
	   SingletonWithReflection instanceOne = SingletonWithReflection.getInstance();
	   SingletonWithReflection instanceTwo = null;
       try {
           Constructor[] constructors = SingletonWithReflection.class.getDeclaredConstructors();
           for (Constructor<SingletonWithReflection> constructor : constructors) {
               constructor.setAccessible(true);
               instanceTwo = (SingletonWithReflection) constructor.newInstance();
               break;
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
       System.out.println(instanceOne.hashCode());
       System.out.println(instanceTwo.hashCode());
}
}
