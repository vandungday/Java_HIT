package Controller;

import java.util.*;

import Model.Bill;
import Model.Customer;
import Model.Employee;
import Model.Product;

public class FunctionController {
	static FileController file = new FileController();
	static Scanner sc = new Scanner(System.in);

	public int Choose(int a, int b) {
		int choose;
		do {
			try {
				do {
					System.out.print("You choose: ");
					choose = Integer.parseInt(sc.nextLine());
				} while (choose < a || choose > b);
				return choose;
			} catch (Exception e) {
				System.out.println("You choose again!!! ");
			}
		} while (true);

	}

	public Double MyParseDouble(String value) {
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			return null;
		}
	}

	public Integer MyParseInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean checkIdCustomer(List<Customer> a, int id) {
		for (Customer c : a) {
			if (id == c.getCustomerID()) {
				return true;
			}
		}
		return false;
	}

	public boolean checkIdEmployee(List<Employee> a, int id) {
		for (Employee c : a) {
			if (id == c.getEmID()) {
				return true;
			}
		}
		return false;
	}
	public boolean checkIdProduct(List<Product> pd, int id) {

		pd = file.ReadProductFromFile("Product.txt");
		for (Product p : pd) {
			if (p.getIdProduct() == id) {
				return true;
			}
		}
		return false;
	}

	public int maxIdBill(List<Bill> b) {
		int m = 100;
		b = file.ReadBillFromFile("Bill.txt");
		for (Bill c : b) {
			if (c.getBillID() > m)
				m = c.getBillID();
		}
		return m;

	}

	public int maxIdCustomer(List<Customer> cus) {
		int m = 100;
		cus = file.ReadCustomerFromFile("Customer.txt");
		for (Customer c : cus) {
			if (c.getCustomerID() > m)
				m = c.getCustomerID();
		}
		return m;

	}
}
