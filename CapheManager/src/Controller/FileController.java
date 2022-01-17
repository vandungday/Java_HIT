package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Account;
import Model.Bill;
import Model.BillEmployeee;
import Model.Customer;
import Model.Employee;
import Model.Product;

public class FileController {

	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private PrintWriter printWriter;
	private Scanner scanner;

	public void OpenFileToWrite(String fileName) {
		try {
			fileWriter = new FileWriter(fileName, true);
			bufferedWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferedWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void CloseFileToWrite() {
		try {
			printWriter.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void OpenFileToRead(String fileName) {
		try {
			scanner = new Scanner(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void CloseFileToRead() {
		scanner.close();
	}

// Product 

	public void WriteProductToFile(String fileName, Product pd) {
		OpenFileToWrite(fileName);
		printWriter
				.println(pd.getIdProduct() + "|" + pd.getNameProduct() + "|" + pd.getPrice() + "|" + pd.getQuantity());
		CloseFileToWrite();
	}

	public Product CreateProductFromData(String data) {
		String[] datas = data.split("\\|");
		Product pd = new Product(Integer.parseInt(datas[0]), datas[1], Double.parseDouble(datas[2]),
				Integer.parseInt(datas[3]));
		return pd;
	}

	public List<Product> ReadProductFromFile(String fileName) {
		OpenFileToRead(fileName);
		List<Product> list = new ArrayList<>();
		while (scanner.hasNext()) {
			String data = scanner.nextLine();
			Product pd = CreateProductFromData(data);
			list.add(pd);
		}
		CloseFileToRead();
		return list;
	}

	public void UpdateProductFile(List<Product> list, String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		OpenFileToWrite(fileName);
		for (Product pd : list) {
			printWriter.println(
					pd.getIdProduct() + "|" + pd.getNameProduct() + "|" + pd.getPrice() + "|" + pd.getQuantity());
		}
		CloseFileToWrite();
	}

// End Product 

// Customer 

	public void WriteCustomerToFile(String fileName, Customer cus) {
		OpenFileToWrite(fileName);
		printWriter.println(cus.getCustomerID() + "|" + cus.getCustomerName() + "|" + cus.getGender() + "|"
				+ cus.getAge() + "|" + cus.getCustomerAddress() + "|" + cus.getCustomerPhone());
		CloseFileToWrite();
	}

	public Customer CreateCustomerFromData(String data) {
		String[] datas = data.split("\\|");
		Customer cus = new Customer(Integer.parseInt(datas[0]), datas[1], datas[2], Integer.parseInt(datas[3]),
				datas[4], datas[5]);
		return cus;
	}

	public List<Customer> ReadCustomerFromFile(String fileName) {
		OpenFileToRead(fileName);
		List<Customer> list = new ArrayList<>();
		while (scanner.hasNext()) {
			String data = scanner.nextLine();
			Customer cus = CreateCustomerFromData(data);
			list.add(cus);
		}
		CloseFileToRead();
		return list;
	}

	public void UpdateCustomerFile(List<Customer> list, String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		OpenFileToWrite(fileName);
		for (Customer cus : list) {
			printWriter.println(cus.getCustomerID() + "|" + cus.getCustomerName() + "|" + cus.getGender() + "|"
					+ cus.getAge() + "|" + cus.getCustomerAddress() + "|" + cus.getCustomerPhone());
		}
		CloseFileToWrite();
	}

// End Customer   

// Account 

	public void WriteAccountToFile(String fileName, Account ac) {
		OpenFileToWrite(fileName);
		printWriter.println(ac.getIdAccount() + "|" + ac.getUserName() + "|" + ac.getPassWord() + "|" + ac.getEmail()
				+ "|" + ac.getCreatAt());
		CloseFileToWrite();
	}

	public Account CreateAccountFromData(String data) {
		String[] datas = data.split("\\|");
		Account ac = new Account(Integer.parseInt(datas[0]), datas[1], datas[2], datas[3], datas[4]);
		return ac;
	}

	public List<Account> ReadAccountFromFile(String fileName) {
		OpenFileToRead(fileName);
		List<Account> list = new ArrayList<>();
		while (scanner.hasNext()) {
			String data = scanner.nextLine();
			Account ac = CreateAccountFromData(data);
			list.add(ac);
		}
		CloseFileToRead();
		return list;
	}

	public void UpdateAccountFile(List<Account> list, String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		OpenFileToWrite(fileName);
		for (Account ac : list) {
			printWriter.println(ac.getIdAccount() + "|" + ac.getUserName() + "|" + ac.getPassWord() + "|"
					+ ac.getEmail() + "|" + ac.getCreatAt());
		}
		CloseFileToWrite();
	}
// End Account

// Employee

	public void WriteEmployeeToFile(String fileName, Employee em) {
		OpenFileToWrite(fileName);
		printWriter.println(em.getEmID() + "|" + em.getEmName() + "|" + em.getEmGender() + "|" + em.getEmAddress() + "|"
				+ em.getEmEntryDate() + "|" + em.getEmPhone() + "|" + em.getEmPassword());
		CloseFileToWrite();
	}

	public Employee CreateEmployeeFromData(String data) {
		String[] datas = data.split("\\|");
		Employee em = new Employee(Integer.parseInt(datas[0]), datas[1], datas[2], datas[3], datas[4], datas[5],
				datas[6]);
		return em;
	}

	public List<Employee> ReadEmployeeFromFile(String fileName) {
		OpenFileToRead(fileName);
		List<Employee> list = new ArrayList<>();
		while (scanner.hasNext()) {
			String data = scanner.nextLine();
			Employee em = CreateEmployeeFromData(data);
			list.add(em);
		}
		CloseFileToRead();
		return list;
	}

	public void UpdateEmployeeFile(List<Employee> list, String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		OpenFileToWrite(fileName);
		for (Employee em : list) {
			printWriter.println(em.getEmID() + "|" + em.getEmName() + "|" + em.getEmGender() + "|" + em.getEmAddress()
					+ "|" + em.getEmEntryDate() + "|" + em.getEmPhone() + "|" + em.getEmPassword());
		}
		CloseFileToWrite();
	}

// End Employee

	// BILL

	public void WriteBillToFile(String fileName, Bill bill) {
		OpenFileToWrite(fileName);
		String tempBill = "";
		tempBill += bill.getBillID() + "*" + bill.getPurchaseDate() + "*" + bill.getCustomerID() + "*"
				+ bill.getCustomerName();
		for (Product product : bill.getListProcProducts()) {
			String temp = product.getIdProduct() + "|" + product.getNameProduct() + "|" + product.getPrice() + "|"
					+ product.getQuantity();
			tempBill += "*" + temp;
		}
		printWriter.println(tempBill);
		CloseFileToWrite();
	}

	public Bill CreateBillFromData(String data) {
		String[] a = data.split("\\*");
		List<Product> listProducts = new ArrayList<>();
		for (int i = 4; i < a.length; i++) {
			Product product = CreateProductFromData(a[i]);
			listProducts.add(product);
		}
		Bill bill = new Bill(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2]), a[3], listProducts);
		return bill;
	}

	public List<Bill> ReadBillFromFile(String fileName) {
		OpenFileToRead(fileName);
		List<Bill> listBills = new ArrayList<>();
		while (scanner.hasNext()) {
			String data = scanner.nextLine();
			Bill bill = CreateBillFromData(data);
			listBills.add(bill);
		}
		CloseFileToRead();
		return listBills;
	}

	public void UpdateBillFile(List<Bill> listBills, String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		OpenFileToWrite(fileName);
		for (Bill bill : listBills) {
			String text = bill.getBillID() + "*" + bill.getPurchaseDate() + "*" + bill.getCustomerID() + "*"
					+ bill.getCustomerName();
			List<Product> listProducts = bill.getListProcProducts();
			for (Product product : listProducts) {
				text += "*" + product.getIdProduct() + "|" + product.getNameProduct() + "|" + product.getPrice() + "|"
						+ product.getQuantity();
			}
			printWriter.println(text);
		}
		CloseFileToWrite();
	}
// END BILL  
	
// BIll Salary
	public void WriteBillEmployeeToFile(String fileName, BillEmployeee em) {
		OpenFileToWrite(fileName);
		printWriter.println(em.getEmID() + "|" + em.getEmName() + "|" + em.getEmPhone() + "|" + em.getEmShift() + "|" + em.getEmDate() );
		CloseFileToWrite();
	}
	
	public BillEmployeee CreateBillEmployeeFromData(String data) {
		String[] datas = data.split("\\|");
		BillEmployeee em = new BillEmployeee(Integer.parseInt(datas[0]), datas[1], datas[2],datas[3], datas[4]);
		return em;
	}

	public List<BillEmployeee> ReadBillEmployeeFromFile(String fileName) {
		OpenFileToRead(fileName);
		List<BillEmployeee> list = new ArrayList<>();
		while (scanner.hasNext()) {
			String data = scanner.nextLine();
			BillEmployeee em = CreateBillEmployeeFromData(data);
			list.add(em);
		}
		CloseFileToRead();
		return list;
	}

	public void UpdateBillEmployeeFile(List<BillEmployeee> list, String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		OpenFileToWrite(fileName);
		for (BillEmployeee em : list) {
			printWriter.println(em.getEmID() + "|" + em.getEmName() + "|" + em.getEmPhone() + "|" + em.getEmShift() + "|" + em.getEmDate() );
		}
		CloseFileToWrite();
	}

// End Bill
}
