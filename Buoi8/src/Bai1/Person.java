package Bai1;

import java.util.Scanner;
public class Person implements Comparable<Person>  {
	int id;
	private String name;
	private String address;
	
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhap id: "); id = sc.nextInt();
			sc.nextLine();
			System.out.print("Nhap ten: "); name = sc.nextLine();
			System.out.print("Nhap dia chi: "); address = sc.nextLine();
			
		} catch(Exception e){
			System.out.println("Nhap khong dung dang du lieu");
		}
		
	}
	
	public Person(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address +  "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public int compareTo(Person o) {
		if(this.getName().compareToIgnoreCase(o.getName())==0) {
    		return o.getAddress().compareTo(this.getAddress());
    	}
    	else {
    		return this.getName().compareTo(o.getName());
    	}		
	}
	
	
}
