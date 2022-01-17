package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import Model.Employee;
import Model.Product;

import java.util.Scanner;

public class EmployeeManager {
	static Scanner sc = new Scanner(System.in);
	static FunctionController functionController = new FunctionController();
	static List<Employee> listEmployee = new ArrayList<Employee>();
	static FileController file = new FileController();
	static Pattern checkPassword = Pattern
			.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{8,}$");
	static Pattern checkPhone = Pattern.compile("^[0-9]{10,20}$");
	static Date date = new Date();
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public void menuEmployeeManager() {
		do {
			System.out.println("=========  Employee Manager  ===========");
			System.out.println("1) Show list of employees");
			System.out.println("2) Add employee to work");
			System.out.println("3) Sort employees by name");
			System.out.println("4) Edit employee information");
			System.out.println("5) Search for employees by name");
			System.out.println("6) Delete employee");
			System.out.println("7) Exit");
			System.out.println("=======================================");
			switch (functionController.Choose(1, 7)) {
			case (1):
				show();
				break;
			case (2):
				add();
				break;
			case (3):
				sortByName();
				break;
			case (4):
				editInfoEm();
				break;
			case (5):
				searchEmByName();
				break;
			case (6):
				delete();
				break;
			case (7):
				System.out.println("Exit successful ");
				return;
			}
		} while (true);
	}

	public void add() {

		Employee em = new Employee();
		List<Employee> listEmployee = file.ReadEmployeeFromFile("Employee.txt");
		em.setEmID(MAX(listEmployee) + 1);

		System.out.print("Enter employee name     : ");
		em.setEmName(sc.nextLine());
		System.out.print("Enter employee gender   : ");
		em.setEmGender(sc.nextLine());
		System.out.print("Enter employee address  : ");
		em.setEmAddress(sc.nextLine());

		em.setEmEntryDate(formatter.format(new Date()));

		String phone;
		do {

			System.out.print("Enter employee phone : ");
			phone = sc.nextLine();
			if (checkPhone(phone)) {
				em.setEmPhone(phone);
				if (checkPhone.matcher(em.getEmPhone()).find()) {
					break;
				} else {
					System.err.println("Invalid  phone");

				}
			} else {
				System.out.println("Phone number already exists");
			}

		} while (true);

		do {
			System.out.print("Enter employee password    : ");
			em.setEmPassword(sc.nextLine());
			if (checkPassword.matcher(em.getEmPassword()).find()) {
				break;
			} else {
				System.out.println("Invalid password");
			}
		} while (true);

		listEmployee.add(em);
		System.out.println("Add successful ^^");
		file.WriteEmployeeToFile("Employee.txt", em);

	}

	public boolean checkPhone(String phone) {
		listEmployee = file.ReadEmployeeFromFile("Employee.txt");
		for (Employee em : listEmployee) {
			if (em.getEmPhone().compareTo(phone) == 0) {
				return false;
			}
		}
		return true;
	}

	public int MAX(List<Employee> a) {
		if (a == null)
			return 0;
		int MAX = 0;
		for (Employee em : a) {
			if (em.getEmID() > MAX)
				MAX = em.getEmID();
		}
		return MAX;
	}

	public void show() {
		listEmployee = file.ReadEmployeeFromFile("Employee.txt");
		System.out.println(
				"====================================List Employees==========================================");
		for (Employee em : listEmployee) {
			System.out.println(em.toString());
		}
		System.out.println(
				"============================================================================================");
	}

	public void editInfoEm() {
		String ac;
		String pw;
		sc.nextLine();
		System.out.print("Login account :");
		ac = sc.nextLine();
		System.out.print("Login password:");
		pw = sc.nextLine();
		boolean isExisted = false;
		listEmployee = file.ReadEmployeeFromFile("Employee.txt");
		for (Employee em : listEmployee) {
			if (ac.compareTo(em.getEmPhone()) == 0 && pw.compareTo(em.getEmPassword()) == 0) {
				isExisted = true;
				System.out.print("Enter employee new name     : ");
				em.setEmName(sc.nextLine());
				System.out.print("Enter employee new gender   : ");
				em.setEmGender(sc.nextLine());
				System.out.print("Enter employee new address  : ");
				em.setEmAddress(sc.nextLine());
				do {
					System.out.print("Enter employee new phone    : ");
					em.setEmPhone(sc.nextLine());
					if (!checkPhone.matcher(em.getEmPhone()).find()) {
						System.err.println("Invalid phone");
					} else
						break;
				} while (true);

				do {
					System.out.print("Enter employee new password : ");
					em.setEmPassword(sc.nextLine());
					if (!checkPassword.matcher(em.getEmPassword()).find()) {
						System.err.println("Invalid password");
					} else
						break;
				} while (true);
				break;
			}
		}
		if (!isExisted) {
			System.err.println("Account or Password wrong!!!");
		} else {
			System.out.println("Edited successful ");
			file.UpdateEmployeeFile(listEmployee, "Employee.txt");
		}

	}

	public void searchEmByName() {
		String name;
		System.out.print("Enter employee name: ");
		name = sc.nextLine();
		name = name.toLowerCase();
		boolean isExisted = false;
		listEmployee = file.ReadEmployeeFromFile("Employee.txt");
		for (Employee em : listEmployee) {

			if (contains(em.getEmName().toLowerCase(), name)) {
				isExisted = true;
				System.out.println(em.toString());
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

	public void delete() {
		String ac;
		String pw;
		listEmployee = file.ReadEmployeeFromFile("Employee.txt");
		System.out.print("Enter account  : ");
		ac = sc.next();
		System.out.print("Emter password : ");
		pw = sc.next();
		boolean isExisted = false;
		for (Employee em : listEmployee) {
//			System.out.println (ps.toString());
			if (ac.compareTo(em.getEmPhone()) == 0 && pw.compareTo(em.getEmPassword()) == 0) {
				listEmployee.remove(em);
				isExisted = true;
				file.UpdateEmployeeFile(listEmployee, "Employee.txt");
				System.out.println("Delete successfull");
				break;
			}
		}

		if (!isExisted) {
			System.err.println("Account or Password wrong!!!");
		}
	}

	public void sortByName() {
		listEmployee = file.ReadEmployeeFromFile("Employee.txt");
		Collections.sort(listEmployee);
		for (Employee em : listEmployee) {
			System.out.println(em.toString());
		}
	}
}
