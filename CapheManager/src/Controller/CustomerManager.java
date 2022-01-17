package Controller;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Model.Bill;
import Model.Customer;

public class CustomerManager {
	static Scanner sc = new Scanner(System.in);
	static FunctionController functionController = new FunctionController();
	static List<Customer> listCustomers = new ArrayList<Customer>();
	static BillManager billManager = new BillManager();
	static FileController file = new FileController();
	static List<Bill> bills = new ArrayList<Bill>();

	public void menuCustomer() {
		do {
			System.out.println();
			System.out.println("======== Customer Manager========");
			System.out.println("1) Show List Customer");
			System.out.println("2) Show VIP Customer ");
			System.out.println("3) Search Customer By Name");
			System.out.println("4) Search Customer VIP By Name");
			System.out.println("5) Sort Customer By Name ");
			System.out.println("6) Sort Custome VIP By Name ");
			System.out.println("7) Exit Customer Manager ");
			System.out.println("==================================");
			System.out.println();
			switch (functionController.Choose(1, 7)) {
			case (1):
				showCustomer("Customer.txt");
				break;
			case (2):
				showCustomer("CustomerVIP.txt");
				break;
			case (3):
				searchCustomerByName("Customer.txt");
				break;
			case (4):
				searchCustomerByName("CustomerVIP.txt");
				break;
			case (5):
				sortCustomerByName("Customer.txt");
				break;
			case (6):
				sortCustomerByName("CustomerVIP.txt");
				break;
			case (7):
				System.out.println("Exit Successfull Customer Manager ");
				return;
			}
		} while (true);
	}

	public void showCustomer(String fileName) {
		listCustomers = file.ReadCustomerFromFile(fileName);
		for (Customer cus : listCustomers) {
			System.out.println(cus.toString());
		}
	}

	public void searchCustomerByName(String fileName) {
		String name;
		System.out.print("Enter customer name: ");
		name = sc.nextLine();
		name = name.toLowerCase();
		boolean isExisted = false;
		listCustomers = file.ReadCustomerFromFile(fileName);
		for (Customer cus : listCustomers) {

			if (contains(cus.getCustomerName().toLowerCase(), name)) {
				isExisted = true;
				System.out.println(cus.toString());
			}
		}
		if (!isExisted) {
			System.out.printf("%s not existed \n", name);
		}
	}

	boolean contains(String haystack, String needle) {
		if (haystack == null)
			return false;

		return haystack.contains(needle.toLowerCase());
	}

	public void sortCustomerByName(String fileName) {
		listCustomers = file.ReadCustomerFromFile(fileName);
		Collections.sort(listCustomers);
		for (Customer cus : listCustomers) {
			System.out.println(cus.toString());
		}
	}

}
