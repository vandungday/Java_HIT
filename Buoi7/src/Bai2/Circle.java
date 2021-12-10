package Bai2;

public class Circle implements IShape {

	private double radius;
	
	

	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	public double getArea() {
		// TODO Auto-generated method stub
		return radius*radius*3.14;
	}

	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*3.14*radius;
	}

}
