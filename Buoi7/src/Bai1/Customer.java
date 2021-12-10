package Bai1;

public class Customer extends Person{
	private int balance;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String address, int balance) {
		super(name, address);
		this.balance=balance;
		// TODO Auto-generated constructor stub
	}


	public void display() {
		System.out.println("Customer name: "+  getName());
		System.out.println("Customer address: " + getAddress());
		System.out.println("Customer balance: " + balance);
	}
	
	
	
}
