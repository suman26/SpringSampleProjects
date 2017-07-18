package com.abhi.design.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	List<Observer> observers =new ArrayList<Observer>();
      int state;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}
	public void notifyAllObservers() {
		for(Observer o: observers)
		{
			o.update();
		}
		
	}
	public void attach(Observer o)
	{
		observers.add(o);
	}
     
      
}
