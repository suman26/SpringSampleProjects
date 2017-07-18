package com.abhi.design.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonWithSerialization implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private SingletonWithSerialization()
	{
		
	}
	protected Object readResolve() {
	    return getInstance();
	}
	private static class SingletonHelper{
        private static final SingletonWithSerialization instance = new SingletonWithSerialization();
    }
    
    public static SingletonWithSerialization getInstance(){
        return SingletonHelper.instance;
    }
    public static void main(String[] args) throws ClassNotFoundException, IOException {
    	SingletonWithSerialization instanceOne = SingletonWithSerialization.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();
        
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SingletonWithSerialization instanceTwo = (SingletonWithSerialization) in.readObject();
        in.close();
        
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
	}
}
