package com.abhi.design.abstractfactory;

public abstract class AbstractFactory {

	public abstract Shape getShape(String shapeType);
	public abstract Color getColor(String colorType);
}
