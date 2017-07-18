package com.abhi.design.abstractfactory;

public class ColorFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		return null;
	}

	@Override
	public Color getColor(String colorType) {
		if(colorType==null)
		return null;
		else if(colorType.equalsIgnoreCase("green"))
			return new Green();
		else if(colorType.equalsIgnoreCase("red"))
			return new Red();
		return null;
	}

	
}
