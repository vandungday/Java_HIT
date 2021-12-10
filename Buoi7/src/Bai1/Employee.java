package Bai1;

public class Employee extends Person{
	private int salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String address, int salary) {
		super(name, address);
		this.salary = salary;
		// TODO Auto-generated constructor stub
	}
	
	public void display() {
		System.out.println("Employee name: "+  getName());
		System.out.println("Employee address: " + getAddress());
		System.out.println("Employee salary: " + salary);
	}

	
}
