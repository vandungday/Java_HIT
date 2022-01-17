package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import Model.Account;
import Model.Bill;
import Model.Customer;
import Model.Employee;
import Model.Product;

public class AccountManager {
	static Scanner sc = new Scanner(System.in);
	static BillManager billManager = new BillManager();
	static FunctionController functionController = new FunctionController();
	static List<Employee> listEmployee = new ArrayList<Employee>();
	static List<Customer> customers = new ArrayList<Customer>();
	static List<Bill> bills = new ArrayList<Bill>();
	static List<Account> listAccounts = new ArrayList<Account>();
	static List<Product> products = new ArrayList<Product>();
	static FileController file = new FileController();
	static Date date = new Date();
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	static Pattern checkEmail = Pattern.compile("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}");
//	static Pattern checkUsername = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{6,}$");
	static Pattern checkUsername = Pattern.compile("^(?=.*[a-z])[A-Za-z0-9]{6,}$");
	static Pattern checkPassword = Pattern
			.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{8,}$");
	static ProductManager productManager = new ProductManager();

	public void menuAccount() {
		do {
			System.out.println();
			System.out.println("============  LOGIN CUSTOMER  ============");
			System.out.println("1) Login");
			System.out.println("2) Register");
			System.out.println("3) Exit ");
			System.out.println("==========================================");
			switch (functionController.Choose(1, 3)) {
			case (1):
				login();
				break;
			case (2):
				register();
				break;
			case (3):
				System.out.println("Exit Account Manager Succesful ");
				return;
			}
		} while (true);
	}

	private void register() {
		Account ac = new Account();
		customers = file.ReadCustomerFromFile("Customer.txt");

		do {
			System.out.print("Enter id customer: ");
			String id = sc.nextLine();
			if (functionController.MyParseInt(id) == null) {
				System.out.println("Invalid id");
			} else if (checkIDAccount(Integer.parseInt(id)) == true) {
				System.out.println("ID already exists");
			} else if (checkID(Integer.parseInt(id))) {
				for (Customer cus : customers) {
					if (Integer.parseInt(id) == cus.getCustomerID())
						ac.setIdAccount(cus.getCustomerID());
				}
				break;
			} else {
				System.out.println("You need enter information");
				Customer customer = new Customer();
				int idTemp = functionController.maxIdCustomer(customers) + 1;
				customer.input(idTemp);
				ac.setIdAccount(customer.getCustomerID());
				file.WriteCustomerToFile("Customer.txt", customer);
				break;
			}

		} while (true);

		do {
			System.out.print("Enter username    : ");
			ac.setUserName(sc.nextLine());
			if (!checkUsername.matcher(ac.getUserName()).find()) {
				System.err.println("Invalid username");
			} else if (checkUsername(ac.getUserName())) {
				System.out.println("Username already exists");
			} else
				break;
		} while (true);

		do {
			System.out.print("Enter password    : ");
			ac.setPassWord(sc.nextLine());
			if (!checkPassword.matcher(ac.getPassWord()).find()) {
				System.err.println("Invalid password");
			} else
				break;
		} while (true);

		do {
			System.out.print("Enter email       : ");
			ac.setEmail(sc.nextLine());
			if (!checkEmail.matcher(ac.getEmail()).find()) {
				System.err.println("Invalid email");
			} else
				break;
		} while (true);
		ac.setCreatAt(formatter.format(date));
		listAccounts.add(ac);
		System.out.println("Register success");
		file.WriteAccountToFile("Account.txt", ac);

	}

	private void login() {
		listAccounts = file.ReadAccountFromFile("Account.txt");
		String us, pw;
		do {
			System.out.print("Enter username    : ");
			us = sc.nextLine();
			System.out.print("Enter password    : ");
			pw = sc.nextLine();
			boolean check = false;
			for (Account ac : listAccounts) {
				if (us.compareTo(ac.getUserName()) == 0 && pw.compareTo(ac.getPassWord()) == 0) {
					check = true;
					System.out.println("Logged in successfully");
					do {
						System.out.println();
						System.out.println("=================  " + ac.getUserName() + "  =====================");
						System.out.println("1) View personal information");
						System.out.println("2) Purchase Online");
						System.out.println("3) Change password");
						System.out.println("4) Log out");
						System.out.println("===================================================");
						System.out.println();
						switch (functionController.Choose(1, 4)) {
						case (1):
							view(ac.getIdAccount());
							break;
						case (2):
							purchaseOnline(ac.getIdAccount());
							break;
						case (3):
							changePassword(ac.getIdAccount());
							break;
						case (4):
							return;
						}
					} while (true);
				}
			}
			if (!check) {
				System.out.println("Account error");
			}
		} while (true);
	}

	private void view(int id) {
		// TODO Auto-generated method stub
		customers = file.ReadCustomerFromFile("Customer.txt");
		for (Customer cus : customers) {
			if (cus.getCustomerID() == id) {
				cus.output();
				break;
			}
		}
	}

	private void purchaseOnline(int id) {
		do {
			System.out.println("=============== Buy Online ==========");
			System.out.println("1) Show menu");
			System.out.println("2) Search menu by price ");
			System.out.println("3) Search menu by name");
			System.out.println("4) Sort menu by price");
			System.out.println("5) Buy online ");
			System.out.println("6) Exit");
			System.out.println("=====================================");
			switch (functionController.Choose(1, 6)) {
			case (1):
				productManager.show();
				break;
			case (2):
				productManager.searchByPrice();
				break;
			case (3):
				productManager.searchByName();
				;
				break;
			case (4):
				productManager.sortPrice();
				break;
			case (5):
				purchase(id);
				break;
			case (6):
				System.out.println("Exit successful");
				return;
			}
		} while (true);
	}

	private void purchase(int id) {
		Bill bill = new Bill();
		bill.setBillID(functionController.maxIdBill(bills) + 1);
		bill.setPurchaseDate(formatter.format(date));
		customers = file.ReadCustomerFromFile("Customer.txt");
		Customer c = new Customer();
		for (Customer cus : customers) {
			if (cus.getCustomerID() == id) {
				c = cus;
				bill.setCustomerID(cus.getCustomerID());
				bill.setCustomerName(cus.getCustomerName());
				break;
			}
		}
		customers = file.ReadCustomerFromFile("Customer.txt");
		billManager.billCustomer(bill);
		if (billManager.checkVIP(id) && billManager.checkExitsInVIP(id) == false) {
			file.WriteCustomerToFile("CustomerVIP.txt", c);
		}
		billManager.billInfo();
	}

	private void changePassword(int id) {
		String oldPw, newPw, confirmPw;

		listAccounts = file.ReadAccountFromFile("Account.txt");
		boolean check = false;
		for (Account ac : listAccounts) {
			if (ac.getIdAccount() == id) {
				do {
					System.out.print("Enter old password : ");
					oldPw = sc.nextLine();
					if (!checkPassword.matcher(oldPw).find()) {
						System.err.println("Invalid password");
					} else if (oldPw.compareTo(ac.getPassWord()) != 0) {
						System.out.println("Old password is not correct");
					} else
						break;
				} while (true);

				do {
					System.out.print("Enter new password  : ");
					newPw = sc.nextLine();
					if (!checkPassword.matcher(newPw).find()) {
						System.err.println("Invalid password");
					} else
						break;
				} while (true);

				do {
					System.out.print("Confirm new password : ");
					confirmPw = sc.nextLine();
					if (!checkPassword.matcher(confirmPw).find()) {
						System.err.println("Invalid password");
					} else if (newPw.compareTo(confirmPw) != 0) {
						System.out.println("Two passwords do not match");
					} else {
						check = true;
						ac.setPassWord(newPw);
						file.UpdateAccountFile(listAccounts, "Account.txt");
						System.out.println("Change password success");
						break;
					}
				} while (true);

				if (check) {
					break;
				}
			}
		}

	}

	private boolean checkUsername(String username) {
		listAccounts = file.ReadAccountFromFile("Account.txt");
		for (Account ac : listAccounts) {
			if (username.compareTo(ac.getUserName()) == 0) {
				return true;
			}
		}
		return false;
	}

	private boolean checkID(int id) {
		customers = file.ReadCustomerFromFile("Customer.txt");
		for (Customer cus : customers) {
			if (id == cus.getCustomerID()) {
				return true;
			}
		}
		return false;
	}

	private boolean checkIDAccount(int id) {
		listAccounts = file.ReadAccountFromFile("Account.txt");
		for (Account ac : listAccounts) {
			if (id == ac.getIdAccount()) {
				return true;
			}
		}
		return false;
	}
}
