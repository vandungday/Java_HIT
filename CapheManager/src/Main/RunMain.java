package Main;

import java.util.*;

import Controller.AccountManager;
import Controller.BillManager;
import Controller.CustomerManager;
import Controller.EmployeeManager;
import Controller.FunctionController;
import Controller.ProductManager;
import Controller.SalaryEmployeeManager;
import Model.Customer;

public class RunMain {
	static Scanner sc = new Scanner(System.in);
	static FunctionController functionController = new FunctionController();
	static ProductManager productManager = new ProductManager();
	static EmployeeManager employeeManager = new EmployeeManager();
	static BillManager billManager = new BillManager();
	static CustomerManager customerManager = new CustomerManager();
	static AccountManager accountManager = new AccountManager();
	static SalaryEmployeeManager salaryEmployeeManager = new SalaryEmployeeManager();
	public static void main(String[] args) {
		int choose = 0;
		do {
			System.out.println();
			System.out.println("=========== HELLO COFFEE =========");
			System.out.println("1) Login Admin");
			System.out.println("2) Login Customer");
			System.out.println("3) Login Employee");
			System.out.println("4) Exit");
			System.out.println("==================================");
			switch (functionController.Choose(1, 4)) {
			case 1:
				if (checkAd())
					menuAdmin();
				else
					System.out.println("Account or Password error");
				break;
			case 2:
				menuCustomer();
				break;
			case 3:
				menuEmployee();
				break;
			case 4:
				System.out.println("Exit successful");
				return;
			}

		} while (true);
	}

	private static void menuAdmin() {
		do {
			System.out.println();
			System.out.println("============  LOGIN ADMIN  =============");
			System.out.println("1) Sell Product");
			System.out.println("2) Employee Manager");
			System.out.println("3) Product Managerment");
			System.out.println("4) Customer Managerment");
			System.out.println("5) Bill Managerment");
			System.out.println("6) Statistic Report");
			System.out.println("7) Bill  Employee");
			System.out.println("8) Exit Menu Admin");
			System.out.println("========================================");
			switch (functionController.Choose(1, 8)) {
			case 1:
				billManager.menuBill();
				break;
			case 2:
				employeeManager.menuEmployeeManager();
				break;
			case 3:
				productManager.menuProductManager();
				break;
			case 4:
				customerManager.menuCustomer();
				break;
			case 5:
				billManager.menuBillManager();
				break;
			case 6:
				billManager.statisticReportBill();
				break;
			case 7:
				salaryEmployeeManager.menuSalaryEmployee();
				break;
			case 8:
				System.out.println("Exit successful");
				return;
			}
		} while (true);

	}

	private static boolean checkAd() {
		String um, pw;
		System.out.print("Enter username: ");
		um = sc.nextLine();
		System.out.print("Enter password: ");
		pw = sc.nextLine();
		if (um.compareTo("a") == 0 && pw.compareTo("a") == 0) {
			return true;
		}
		return false;
	}

	private static void menuCustomer() {
		accountManager.menuAccount();
	}
	
	private static void menuEmployee() {
		salaryEmployeeManager.loginEmployee();
	}
}
