package com.abhi.design.abstractfactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {

		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		//get an object of Shape Circle
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		//call draw method of Shape Circle
		shape1.draw();
		//get an object of Shape Rectangle
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		//call draw method of Shape Rectangle
		shape2.draw();
		//get an object of Shape Square
		Shape shape3 = shapeFactory.getShape("SQUARE");
		//call draw method of Shape Square
		shape3.draw();
		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
		//get an object of Color Red
		Color color1 = colorFactory.getColor("RED");
		//call fill method of Red
		color1.fill();
		//get an object of Color Green
		Color color2 = colorFactory.getColor("Green");
		//call fill method of Green
		color2.fill();
		
	}
}
