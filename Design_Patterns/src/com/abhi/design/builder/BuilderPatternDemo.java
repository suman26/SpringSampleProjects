package com.abhi.design.builder;

public class BuilderPatternDemo {

	public static void main(String[] args) {
		
		MealBuilder mealBuilder =new MealBuilder();
		Meal nonVegMeal=mealBuilder.prepareNonVegMeal();
		nonVegMeal.showItems();
		System.out.println(nonVegMeal.getCost());
		
		Meal vegMeal=mealBuilder.prepareVegMeal();
		vegMeal.showItems();
		System.out.println(vegMeal.getCost());
	}

}
