package Controller;

import java.beans.ParameterDescriptor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.sound.midi.Soundbank;

import Model.Bill;
import Model.Customer;
import Model.Employee;
import Model.Product;

public class BillManager {
	static Scanner sc = new Scanner(System.in);
	static FunctionController functionController = new FunctionController();
	static List<Employee> listEmployee = new ArrayList<Employee>();
	static List<Customer> customers = new ArrayList<Customer>();
	static List<Bill> bills = new ArrayList<Bill>();
	static List<Product> products = new ArrayList<Product>();
	static FileController file = new FileController();
	static Date date = new Date();
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public void menuBill() {
		do {
			System.out.println("1) Are you old customer ? ");
			System.out.println("2) Are you new customer ? ");
			System.out.println("3) Exit menu bill ");
			switch (functionController.Choose(1, 3)) {
			case (1):
				oldCustomer();
				break;
			case (2):
				newCustomer();
				break;
			case (3):
				System.out.println("Exit successfull menu bill");
				return;
			}
		} while (true);

	}

	public void oldCustomer() {
		String tempID;
		customers = file.ReadCustomerFromFile("Customer.txt");
		do {
			System.out.print("Enter Customer ID: ");
			tempID = sc.nextLine();
			if (functionController.MyParseInt(tempID) == null) {
				System.out.println("Invalid data");
			} else if (!functionController.checkIdCustomer(customers, Integer.parseInt(tempID))) {
				System.out.println("ID doesn't exist !!");
			} else {
				break;
			}
		} while (true);

		Bill bill = new Bill();
		int m = functionController.maxIdBill(bills) + 1;

		bill.setBillID(m);
		bill.setPurchaseDate(formatter.format(date));
		for (Customer c : customers) {
			if (c.getCustomerID() == Integer.parseInt(tempID)) {
				if (checkVIP(c.getCustomerID()) == true && checkExitsInVIP(c.getCustomerID()) == false) {
					file.WriteCustomerToFile("CustomerVIP.txt", c);
				}
				bill.setCustomerID(c.getCustomerID());
				bill.setCustomerName(c.getCustomerName());
			}
		}

		billCustomer(bill);

		for (Customer c : customers) {
			if (c.getCustomerID() == Integer.parseInt(tempID)) {
				if (checkVIP(c.getCustomerID()) == true) {
					file.WriteBillToFile("BillVIP.txt", bill);
				}
				if (checkVIP(c.getCustomerID()) == true && checkExitsInVIP(c.getCustomerID()) == false) {
					file.WriteCustomerToFile("CustomerVIP.txt", c);
				}
			}
		}
		billInfo();

	}

	public void newCustomer() {
		Bill bill = new Bill();
		bill.setBillID(functionController.maxIdBill(bills) + 1);
		bill.setPurchaseDate(formatter.format(date));
		int id = functionController.maxIdCustomer(customers) + 1;
		Customer cus = new Customer();
		cus.input(id);
		file.WriteCustomerToFile("Customer.txt", cus);
		bill.setCustomerID(cus.getCustomerID());
		bill.setCustomerName(cus.getCustomerName());
		customers = file.ReadCustomerFromFile("Customer.txt");
		billCustomer(bill);
		if (checkVIP(cus.getCustomerID())) {
			file.WriteCustomerToFile("CustomerVIP.txt", cus);
		}
		billInfo();
	}

	public void billInfo() {
		bills = file.ReadBillFromFile("Bill.txt");
		for (int i = bills.size() - 1; i >= 0; i--) {
			if (i == bills.size() - 1) {
				System.out.println("========================================================= BILL "
						+ bills.get(i).getBillID() + " =========================================================");
				System.out.println("ID BILL: " + bills.get(i).getBillID() + "\t         Date Founded: "
						+ bills.get(i).getPurchaseDate());
				System.out.printf(
						"ID CUSTOMER: " + bills.get(i).getCustomerID() + "\t Name: " + bills.get(i).getCustomerName());
				System.out.printf("\n%-20s %-30s %-20s %-20s %-20s \n", "ID", "Name", "Price", "Quantity", "Total");
				if (!checkVIPBill(bills.get(i).getBillID())) {
					bills.get(i).outputProducts();
				} else
					bills.get(i).outputProductsVIP();
				System.out.println(
						"============================================================================================================================");
				break;
			}
		}
	}

	public boolean checkVIP(int idCustomer) {
		customers = file.ReadCustomerFromFile("Customer.txt");
		bills = file.ReadBillFromFile("Bill.txt");
		double sum = 0;
		for (Bill b : bills) {
			if (b.getCustomerID() == idCustomer) {
				sum += b.sumProducts();
			}
			if (sum >= 1000000) {
				return true;
			}
		}
		return false;
	}

	public boolean checkVIPBill(int ID) {
		List<Bill> lbills = file.ReadBillFromFile("BillVIP.txt");
		if (lbills.isEmpty())
			return false;
		for (Bill b : lbills) {
			if (b.getBillID() == ID) {
				return true;
			}
		}
		return false;
	}

	public boolean checkExitsInVIP(int idCustomer) {
		List<Customer> customersVIP = file.ReadCustomerFromFile("CustomerVIP.txt");
		for (Customer cusVIP : customersVIP) {
			if (cusVIP.getCustomerID() == idCustomer) {
				return true;
			}
		}
		return false;
	}

	public void billCustomer(Bill bill) {
		List<Product> productBought = new ArrayList<Product>();
		products = file.ReadProductFromFile("Product.txt");
		int i = 0;
		while (true) {
			products = file.ReadProductFromFile("Product.txt");
			int checkIdProduct = 0;
			int checkQuantityToBill = 0;
			int oldQuantity = 0;
			Product productTemp = new Product();
			do {
				String id, qtt;
				do {
					System.out.printf("Enter product %d \n", i + 1);
					System.out.print("\t Enter ID      : ");
					id = sc.nextLine();
					if (functionController.MyParseInt(id) == null) {
						System.out.println("Invalid ID");
					} else {
						break;
					}

				} while (true);

				if (id.compareTo("-1") == 0) {
					break;
				}
				do {
					System.out.print("\t Enter Quantity:  ");
					qtt = sc.nextLine();
					if (functionController.MyParseInt(qtt) == null) {
						System.out.println("Invalid Quantity");
					} else
						break;
				} while (true);

				for (Product p : products) {
					if (Integer.parseInt(id) == p.getIdProduct()) {
						productTemp = p;
						oldQuantity = p.getQuantity();
					}
				}

				if (functionController.MyParseInt(id) == null || functionController.MyParseInt(qtt) == null) {
					System.out.println("Invalid data");
				} else if (!functionController.checkIdProduct(products, Integer.parseInt(id))
						&& Integer.parseInt(id) != -1) {
					System.out.println("Id doesn't exist !!!");
				} else if (Integer.parseInt(qtt) <= 0) {
					System.out.println("Invalid Quantity ");
				} else if (Integer.parseInt(qtt) > oldQuantity) {
					System.out.println("Quantity doesn't enough");
				} else {
					checkIdProduct = Integer.parseInt(id);
					checkQuantityToBill = Integer.parseInt(qtt);
					i++;
					break;
				}

			} while (true);

			if (checkIdProduct == 0) {
				break;
			}
			for (Product a : products) {
				if (checkIdProduct == a.getIdProduct()) {
					int temp = oldQuantity - checkQuantityToBill;
					a.setQuantity(temp);
					file.UpdateProductFile(products, "Product.txt");
				}
			}
			productTemp.setQuantity(checkQuantityToBill);
			productBought.add(productTemp);
		}
		bill.setListProcProducts(productBought);

		bills.add(bill);
		file.WriteBillToFile("Bill.txt", bill);
	}

	public void menuBillManager() {
		do {
			System.out.println("1) Show bill ");
			System.out.println("2) Search bill by ID Bill");
			System.out.println("3) Search bill by ID Customer ");
			System.out.println("4) Search bill by Name Customer ");
			System.out.println("5) Exit Bill Manager ");
			switch (functionController.Choose(1, 5)) {
			case (1):
				showBill();
				break;
			case (2):
				searchBillById();
				break;
			case (3):
				searchCustomerById();
				break;
			case (4):
				searchBillByNameCustomer();
				break;
			case (5):
				System.out.println("Exit successful ^^");
				return;
			}
		} while (true);
	}

	public void searchCustomerById() {
		String ID;
		do {
			System.out.print("Enter ID Customer you need search: ");
			ID = sc.nextLine();
			if (functionController.MyParseInt(ID) == null) {
				System.out.println("Invalid id");
			} else if (!checkIdCustomer(Integer.parseInt(ID))) {
				System.out.println("ID Customer not exist in Bill");
			} else {
				break;
			}
		} while (true);

		System.out.println();
		bills = file.ReadBillFromFile("Bill.txt");
		for (Bill b : bills) {
			if (Integer.parseInt(ID) == b.getCustomerID()) {
				System.out.println("============================================================= BILL " + b.getBillID()
						+ " =========================================================");
				System.out.println("ID BILL: " + b.getBillID() + "\t         Date Founded: " + b.getPurchaseDate());
				System.out.printf("ID CUSTOMER: " + b.getCustomerID() + "\t Name: " + b.getCustomerName());
				System.out.printf("\n%-20s %-30s %-20s %-20s %-20s \n", "ID", "Name", "Price", "Quantity", "Total");
				if (!checkVIPBill(b.getBillID())) {
					b.outputProducts();
				} else
					b.outputProductsVIP();
				System.out.println(
						"================================================================================================================================");
			}
		}

	}

	public void showBill() {
		bills = file.ReadBillFromFile("Bill.txt");
		System.out.println(bills.size());
		for (int i = 0; i < bills.size(); i++) {
			System.out.println("========================================================= BILL "
					+ bills.get(i).getBillID() + " =========================================================");
			System.out.println("ID BILL: " + bills.get(i).getBillID() + "\t         Date Founded: "
					+ bills.get(i).getPurchaseDate());
			System.out.printf(
					"ID CUSTOMER: " + bills.get(i).getCustomerID() + "\t Name: " + bills.get(i).getCustomerName());
			System.out.printf("\n%-20s %-30s %-20s %-20s %-20s \n", "ID", "Name", "Price", "Quantity", "Total");
			if (!checkVIPBill(bills.get(i).getBillID())) {
				bills.get(i).outputProducts();
			} else
				bills.get(i).outputProductsVIP();
			System.out.println(
					"============================================================================================================================");
		}
	}

	public void searchBillById() {
		String ID;
		do {
			System.out.print("Enter ID Bill you need search: ");
			ID = sc.nextLine();
			if (functionController.MyParseInt(ID) == null) {
				System.out.println("Invalid id");
			} else if (!checkIdBill(Integer.parseInt(ID))) {
				System.out.println("ID not exist in Bill");
			} else {
				break;
			}
		} while (true);

		System.out.println();
		bills = file.ReadBillFromFile("Bill.txt");
		for (Bill b : bills) {
			if (Integer.parseInt(ID) == b.getBillID()) {
				System.out.println("============================================================= BILL " + b.getBillID()
						+ " =========================================================");
				System.out.println("ID BILL: " + b.getBillID() + "\t         Date Founded: " + b.getPurchaseDate());
				System.out.printf("ID CUSTOMER: " + b.getCustomerID() + "\t Name: " + b.getCustomerName());
				System.out.printf("\n%-20s %-30s %-20s %-20s %-20s \n", "ID", "Name", "Price", "Quantity", "Total");
				if (!checkVIPBill(b.getBillID())) {
					b.outputProducts();
				} else
					b.outputProductsVIP();
				System.out.println(
						"================================================================================================================================");
			}
		}
	}

	public boolean checkIdBill(int id) {
		bills = file.ReadBillFromFile("Bill.txt");
		for (Bill b : bills) {
			if (id == b.getBillID())
				return true;
		}
		return false;
	}

	public boolean checkIdCustomer(int id) {
		bills = file.ReadBillFromFile("Bill.txt");
		for (Bill b : bills) {
			if (id == b.getCustomerID())
				return true;
		}
		return false;
	}

	public void searchBillByNameCustomer() {
		String name;
		System.out.print("Enter name customer you need search: ");
		name = sc.nextLine();
		name = name.toLowerCase();
		System.out.println();
		bills = file.ReadBillFromFile("Bill.txt");
		boolean isExisted = false;
		for (Bill b : bills) {
			if (contains(b.getCustomerName().toLowerCase(), name)) {
				isExisted = true;
				System.out.println();
				System.out.println("=========================================================== BILL " + b.getBillID()
						+ " ===========================================================");
				System.out.println("ID BILL: " + b.getBillID() + "\t         Date Founded: " + b.getPurchaseDate());
				System.out.printf("ID CUSTOMER: " + b.getCustomerID() + "\t Name: " + b.getCustomerName());
				System.out.printf("\n%-20s %-30s %-20s %-20s %-20s \n", "ID", "Name", "Price", "Quantity", "Total");
				if (!checkVIPBill(b.getBillID())) {
					b.outputProducts();
				} else
					b.outputProductsVIP();
				System.out.println(
						"================================================================================================================================");
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

	public void statisticReportBill() {

		do {
			System.out.println("==========Statistic Report==========");
			System.out.println("1) Show total revenue");
			System.out.println("2) Show revenue each month in year");
			System.out.println("3) Show total number of goods sold ");
			System.out.println("4) Show total number of goods sold by month ");
			System.out.println("5) Exit ");
			System.out.println("====================================");
			switch (functionController.Choose(1, 6)) {
			case (1):
				showTotal();
				break;
			case (2):
				showMoth();
				break;
			case (3):
				sortProductQuantity();
				break;
			case (4):
				sortProductQuantityByMoth();
				break;
			case (5):
				System.out.println("Exit successful ");
				return;
			}
		} while (true);

	}

	public void showTotal() {
		bills = file.ReadBillFromFile("Bill.txt");
		double sum = 0;
		for (Bill b : bills) {
			if (checkVIP(b.getCustomerID())) {
				System.out.printf("%-20s %-20f \n", b.getPurchaseDate(), b.sumProductsVIP());
				sum += b.sumProductsVIP();
			} else {
				System.out.printf("%-20s %-20f \n", b.getPurchaseDate(), b.sumProducts());
				sum += b.sumProducts();
			}
		}
		System.out.println("\n Sum Total = " + sum);
	}

	public void showMoth() {
		bills = file.ReadBillFromFile("Bill.txt");
		double sum = 0;
		String month;
		System.out.print("Enter month to report statistics: ");
		month = sc.nextLine();
		System.out.printf("%-20s %-20s \n", "Date", "Sum");
		int m = 0;
		for (Bill b : bills) {
			try {
				Date date = formatter.parse(b.getPurchaseDate());
				m = getMonthInt(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (m == Integer.parseInt(month)) {
				if (checkVIP(b.getCustomerID())) {
					System.out.printf("%-20s %-20f \n", b.getPurchaseDate(), b.sumProductsVIP());
					sum += b.sumProductsVIP();
				} else {
					System.out.printf("%-20s %-20f \n", b.getPurchaseDate(), b.sumProducts());
					sum += b.sumProducts();
				}
			}
		}
		System.out.println("\n Sum Total of " + month + " = " + sum);
	}

	public int getMonthInt(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		return Integer.parseInt(dateFormat.format(date));
	}

	public void sortProductQuantity() {
		List<Product> productTemp = file.ReadProductFromFile("Product.txt");
		for (Product p : productTemp) {
			p.setQuantity(0);
		}
		bills = file.ReadBillFromFile("Bill.txt");
		for (Bill bill : bills) {
			for (Product p : productTemp) {
				for (Product pro : bill.getListProcProducts()) {
					if (p.getIdProduct() == pro.getIdProduct()) {
						int a = p.getQuantity();
						int b = pro.getQuantity();
						int c = a + b;
						p.setQuantity(c);
					}
				}
			}
		}
		Collections.sort(productTemp, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return (int) (o2.getQuantity() - o1.getQuantity());
			}
		});
		System.out.printf("%-20s %-20s %-20s %-20s \n", "Name", "Quantity", "Price", "Total");
		System.out.println();
		for (Product p : productTemp) {
			System.out.printf("%-20s %-20d %-20f %-20f \n", p.getNameProduct(), p.getQuantity(), p.getPrice(),
					p.getPrice() * p.getQuantity());
		}
		System.out.println();
	}

	public void sortProductQuantityByMoth() {
		List<Product> productTemp = file.ReadProductFromFile("Product.txt");
		for (Product p : productTemp) {
			p.setQuantity(0);
		}
		System.out.print("Enter month : ");
		String month = sc.nextLine();
		int m = 0;
		bills = file.ReadBillFromFile("Bill.txt");
		for (Bill bill : bills) {
			try {
				Date date = formatter.parse(bill.getPurchaseDate());
				m = getMonthInt(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (m == Integer.parseInt(month)) {
				for (Product p : productTemp) {
					for (Product pro : bill.getListProcProducts()) {
						if (p.getIdProduct() == pro.getIdProduct()) {
							int a = p.getQuantity();
							int b = pro.getQuantity();
							int c = a + b;
							p.setQuantity(c);
						}
					}
				}
			}
		}

		Collections.sort(productTemp, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return (int) (o2.getQuantity() - o1.getQuantity());
			}
		});

		System.out.printf("%-20s %-20s %-20s %-20s \n", "Name", "Quantity", "Price", "Total");
		System.out.println();
		for (Product p : productTemp) {
			System.out.printf("%-20s %-20d %-20f %-20f \n", p.getNameProduct(), p.getQuantity(), p.getPrice(),
					p.getPrice() * p.getQuantity());
		}
		System.out.println();
	}

}
