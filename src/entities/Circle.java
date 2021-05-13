package entities;

import entities.enums.Color;

public class Circle extends Shape {

	
	private double radius;
	
	
	
	public Circle() {
		super();
	}


	public Circle(Color color, double radiurs) {
		super(color);
		this.radius = radiurs;
	}

	

	public double getRadiurs() {
		return radius;
	}


	public void setRadiurs(double radiurs) {
		this.radius = radiurs;
	}


	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

}
