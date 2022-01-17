package Model;

import java.util.Scanner;

import Controller.FunctionController;

public class Customer implements Comparable<Customer> {
	static FunctionController functionController = new FunctionController();
	private int customerID;
	private String customerName;
	private String gender;
	private int age;
	private String customerAddress;
	private String customerPhone;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerID2, String customerName2) {
		super();
		customerID = customerID2;
		customerName = customerName2;
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerID, String customerName, String gender, int age, String customerAddress,
			String customerPhone) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.gender = gender;
		this.age = age;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Override
	public String toString() {
		return customerID + "|" + customerName + "|" + gender + "|" + age + "|" + customerAddress + "|" + customerPhone;
	}

	public void output() {
		System.out.println("==============Information Customer===========");
		System.out.println("\t ID      : " + customerID);
		System.out.println("\t Name    : " + customerName);
		System.out.println("\t Gender  : " + gender);
		System.out.println("\t Age     : " + age);
		System.out.println("\t Address : " + customerAddress);
		System.out.println("\t Phone   : " + customerPhone);
		System.out.println("============================================");
	}

	public void input(int Id) {
		Scanner sc = new Scanner(System.in);
		String regexGender = "^(nam)|(nữ)$";
		String regexPhone = "^[0-9\\-\\+]{9,15}$";
		customerID = Id;
		System.out.print("\tEnter customer name: ");
		customerName = sc.nextLine();

		do {
			System.out.print("\tEnter gender: ");
			gender = sc.nextLine().toLowerCase();
			if (!gender.matches(regexGender))
				System.out.println("Invalid gender");
			else
				break;
		} while (true);

		do {
			String checkAge;
			System.out.print("\tEnter age: ");
			checkAge = sc.nextLine();
			if (functionController.MyParseInt(checkAge) != null) {
				age = Integer.parseInt(checkAge);
				break;
			} else {
				System.out.println("Invalid data");
			}
		} while (true);

		System.out.print("\tEnter address: ");
		customerAddress = sc.nextLine();

		do {
			System.out.print("\tEnter phone number:");
			customerPhone = sc.nextLine();
			if (!customerPhone.matches(regexPhone))
				System.out.println("Invalid phone");
			else
				break;
		} while (true);
	}

	@Override
	public int compareTo(Customer o) {
		return this.getCustomerName().compareTo(o.getCustomerName());
	}

}
