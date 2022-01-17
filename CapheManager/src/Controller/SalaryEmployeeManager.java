package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.text.ChangedCharSetException;
import java.util.Set;
import java.util.HashSet;

import Model.Account;
import Model.Bill;
import Model.BillEmployeee;
import Model.Customer;
import Model.Employee;
import Model.Product;

public class SalaryEmployeeManager {
	static Scanner sc = new Scanner(System.in);
	static FunctionController functionController = new FunctionController();
	static List<Employee> listEmployee = new ArrayList<Employee>();
	static List<Product> products = new ArrayList<Product>();
	static List<BillEmployeee> listBillEmployeees = new ArrayList<BillEmployeee>();
	static FileController file = new FileController();
	static Date date = new Date();
	static BillManager billManager = new BillManager();
	static ProductManager productManager = new ProductManager();
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static String checkShift = "^(tối)|(sáng)$";
	static Pattern checkPassword = Pattern
			.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{8,}$");

	public void menuSalaryEmployee() {

		do {
			System.out.println("1) Enter employee salary ");
			System.out.println("2) Show salary employee");
			System.out.println("3) Sort salary employee");
			System.out.println("4) Exit");
			switch (functionController.Choose(1, 4)) {
			case (1):
				enterSalary();
				break;
			case (2):
				showSalary();
				break;
			case (3):
				sortSalary();
				break;
			case (4):
				System.out.println("Exit successfull ^^");
				return;
			}
		} while (true);
	}

	private void enterSalary() {
		BillEmployeee billEmployeee = new BillEmployeee();
		listEmployee = file.ReadEmployeeFromFile("Employee.txt");
		String ID;
		do {
			System.out.print("Enter ID Eployee: ");
			ID = sc.nextLine();
			if (functionController.MyParseInt(ID) == null) {
				System.out.println("Invalid data");
			} else if (!functionController.checkIdEmployee(listEmployee, Integer.parseInt(ID))) {
				System.out.println("ID not exist ");
			} else {
				billEmployeee.setEmID(Integer.parseInt(ID));
				break;
			}
		} while (true);

		for (Employee employee : listEmployee) {
			if (employee.getEmID() == Integer.parseInt(ID)) {
				billEmployeee.setEmName(employee.getEmName());
				billEmployeee.setEmPhone(employee.getEmPhone());
			}
		}
		do {
			System.out.print("Enter shift: ");
			String shift = sc.nextLine();
			shift = shift.toLowerCase();
			if (!shift.toLowerCase().matches(checkShift)) {
				System.out.println("Invalid data");
			} else {
				billEmployeee.setEmShift(shift);
				break;
			}
		} while (true);

		billEmployeee.setEmDate(formatter.format(date));
		file.WriteBillEmployeeToFile("BillEmployee.txt", billEmployeee);
		System.out.println("Enter success ~.~ ");
		listBillEmployeees.add(billEmployeee);
	}

	private void showSalary() {
		listBillEmployeees = file.ReadBillEmployeeFromFile("BillEmployee.txt");
		int month = getMonthInt(date);
		int year = getYearInt(date);
		int mo = 0;
		int y = 0;
		Set<Integer> emID = new HashSet<Integer>();
		for (BillEmployeee be : listBillEmployeees) {
			try {
				Date date = formatter.parse(be.getEmDate());
				mo = getMonthInt(date);
				y = getYearInt(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			if (mo == month && y == year && emID.contains(be.getEmID()) == false) {
				System.out.println();
				emID.add(be.getEmID());
				System.out.println("         Bill Employee     ");
				System.out
						.println("ID: " + be.getEmID() + "\t Name: " + be.getEmName() + "\t Phone: " + be.getEmPhone());
				System.out.println("Moth: " + mo + "\t Year: " + y);
				System.out.println("Morning Shift: " + sumMorning(be.getEmID(), month, year) + "\t Night Shift: "
						+ sumNight(be.getEmID(), month, year));
				int m = sumMorning(be.getEmID(), month, year);
				int n = sumNight(be.getEmID(), month, year);
				System.out.println("Sum Total: " + (m * 15000 * 4 + n * 18000 * 4));
				System.out.println();
			}
		}

	}

	public int getMonthInt(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		return Integer.parseInt(dateFormat.format(date));
	}

	public int getYearInt(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		return Integer.parseInt(dateFormat.format(date));
	}

	private int sumMorning(int id, int month, int year) {
		int count = 0;
		int mo = 0, y = 0;
		listBillEmployeees = file.ReadBillEmployeeFromFile("BillEmployee.txt");
		for (BillEmployeee be : listBillEmployeees) {
			try {
				Date date = formatter.parse(be.getEmDate());
				mo = getMonthInt(date);
				y = getYearInt(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (be.getEmID() == id && be.getEmShift().toLowerCase().compareTo("sáng") == 0 && mo == month
					&& y == year) {
				count++;

			}
		}
		return count;
	}

	private int sumNight(int id, int month, int year) {
		int count = 0;
		int mo = 0, y = 0;
		listBillEmployeees = file.ReadBillEmployeeFromFile("BillEmployee.txt");
		for (BillEmployeee be : listBillEmployeees) {
			try {
				Date date = formatter.parse(be.getEmDate());
				mo = getMonthInt(date);
				y = getYearInt(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (be.getEmID() == id && be.getEmShift().toLowerCase().compareTo("tối") == 0 && mo == month && y == year) {
				count++;

			}
		}
		return count;
	}

	private void sortSalary() {
		listBillEmployeees = file.ReadBillEmployeeFromFile("BillEmployee.txt");
		int month = getMonthInt(date);
		int year = getYearInt(date);
		int mo = 0;
		int y = 0;
		Set<Integer> emID = new HashSet<Integer>();
		ArrayList<Integer> salary = new ArrayList<Integer>();
		for (BillEmployeee be : listBillEmployeees) {
			try {
				Date date = formatter.parse(be.getEmDate());
				mo = getMonthInt(date);
				y = getYearInt(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (mo == month && y == year && emID.contains(be.getEmID()) == false) {
				emID.add(be.getEmID());
				int m = sumMorning(be.getEmID(), month, year);
				int n = sumNight(be.getEmID(), month, year);
				salary.add(m * 15000 * 4 + n * 18000 * 4);
			}
		}
		salary.sort(null);

		long min = salary.get(0);
		int i = 1;
		Set<Integer> ID = new HashSet<Integer>();

		System.out.printf("%-20s %-20s %-20s \n", "ID", "Name", "Sum");
		boolean check = false;
		long Max = salary.get(salary.size() - 1);
		for (int j = 0; j < listBillEmployeees.size(); j++) {
			if (i == salary.size())
				break;
			try {
				Date date = formatter.parse(listBillEmployeees.get(j).getEmDate());
				mo = getMonthInt(date);
				y = getYearInt(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			for (int k = 0; k < listBillEmployeees.size(); k++) {
				BillEmployeee a = listBillEmployeees.get(j);
				BillEmployeee b = listBillEmployeees.get(k);
				int m = sumMorning(b.getEmID(), month, year);
				int n = sumNight(b.getEmID(), month, year);
				long sum = m * 15000 * 4 + n * 18000 * 4;

				if (mo == month && y == year && ID.contains(b.getEmID()) == false && sum == Max) {

					System.out.printf("%-20s %-20s %-20d \n", b.getEmID(), b.getEmName(), Max);
					ID.add(b.getEmID());
					if (i == salary.size())
						break;
					else {
						Max = salary.get(salary.size() - 1 - i);
						i++;
					}

				}
			}
		}
	}

	public void loginEmployee() {
		listEmployee = file.ReadEmployeeFromFile("Employee.txt");
		String us, pw;
		do {
			System.out.print("Enter phone    : ");
			us = sc.nextLine();
			System.out.print("Enter password    : ");
			pw = sc.nextLine();
			boolean check = false;
			for (Employee em : listEmployee) {
				if (us.compareTo(em.getEmPhone()) == 0 && pw.compareTo(em.getEmPassword()) == 0) {
					check = true;
					System.out.println("Logged in successfully");
					do {
						System.out.println();
						System.out.println("=================  " + em.getEmName() + "  =====================");
						System.out.println("1) View personal information");
						System.out.println("2) View salary information");
						System.out.println("3) Sale Product");
						System.out.println("4) Change password");
						System.out.println("5) Log out");
						System.out.println("===================================================");
						System.out.println();
						switch (functionController.Choose(1, 5)) {
						case (1):
							viewInformation(em.getEmID());
							break;
						case (2):
							viewSalary(em.getEmID());
							break;
						case (3):
							sale();
							break;
						case (4):
							changePassword(em.getEmID());
							break;
						case (5):
							return;
						}
					} while (true);
				}
			}
			if (!check) {
				System.out.println("Account Employee error");
			}
		} while (true);
	}

	private void viewInformation(int ID) {
		listEmployee = file.ReadEmployeeFromFile("Employee.txt");
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s  \n", "ID", "Name", "Gender", "Phone", "Address",
				"EmtryDate");
		for (Employee em : listEmployee) {
			if (em.getEmID() == ID) {
				System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s \n", em.getEmID(), em.getEmName(),
						em.getEmGender(), em.getEmPhone(), em.getEmAddress(), em.getEmEntryDate());
			}
		}
	}

	private void viewSalary(int ID) {
		listBillEmployeees = file.ReadBillEmployeeFromFile("BillEmployee.txt");
		int month = getMonthInt(date);
		int year = getYearInt(date);
		int mo = 0;
		int y = 0;
		for(Employee em: listBillEmployeees) {
			if(em.getEmID()==ID){
				System.out.printf("%30s",em.getEmName());
				break;
			}
		}
		System.out.println();
		System.out.println("=========================================================");
		System.out.printf("%-30s %-20s %-20s \n", "Date", "Shift", "Money");
		long sum = 0;
		for (BillEmployeee be : listBillEmployeees) {
			try {
				Date date = formatter.parse(be.getEmDate());
				mo = getMonthInt(date);
				y = getYearInt(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (mo == month && y == year && be.getEmID() == ID) {
				if (be.getEmShift().toLowerCase().compareTo("sáng") == 0) {
					System.out.printf("%-30s %-20s %-20d \n", be.getEmDate(), "Sáng", 4 * 15000);
					sum += 4 * 15000;
				} else {
					System.out.printf("%-30s %-20s %-20d \n", be.getEmDate(), "Tối", 4 * 18000);
					sum += 4 * 18000;
				}
			}
		}
		System.out.printf("%-50s %-20d", "Sum = ", sum);
		System.out.println("\n=========================================================");
		System.out.println("\n");

	}

	private void sale() {
		do {
			System.out.println("1) Show menu");
			System.out.println("2) Sale Product");
			System.out.println("3) Exit");
			switch (functionController.Choose(1, 3)) {
			case (1):
				productManager.show();
				break;
			case (2):
				billManager.menuBill();
			case (3):
				return;
			}
		} while (true);
	}

	private void changePassword(int ID) {
		String oldPw, newPw, confirmPw;

		listEmployee = file.ReadEmployeeFromFile("Employee.txt");
		boolean check = false;
		for (Employee em : listEmployee) {
			if (em.getEmID() == ID) {
				do {
					System.out.print("Enter old password : ");
					oldPw = sc.nextLine();

					if (oldPw.compareTo(em.getEmPassword()) != 0) {
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
						em.setEmPassword(newPw);
						file.UpdateEmployeeFile(listEmployee, "Employee.txt");
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

}
