package com.abhi.design.abstractfactory;

public class ShapeFactory extends AbstractFactory{

	@Override
	public Shape getShape(String shapeType) {
		if(shapeType==null)
		return null;
		else if(shapeType.equalsIgnoreCase("rectangle"))
			return new Rectangle();
		else if(shapeType.equalsIgnoreCase("square"))
			return new Square();
		else if(shapeType.equalsIgnoreCase("circle"))
			return new Circle();
		return null;
	}

	@Override
	public Color getColor(String colorType) {
		return null;
	}

}
