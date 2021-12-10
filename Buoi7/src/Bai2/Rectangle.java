package Bai2;

public class Rectangle implements IShape {

	private double length;
	private double width;

	public Rectangle() {
		
	}
	public Rectangle(double length, double width) {
		this.length=length;
		this.width = width;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return length*width;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*(length + width);
	}

}
