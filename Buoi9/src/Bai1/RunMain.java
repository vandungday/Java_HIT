package Bai1;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
public class RunMain {
	static List<Account> account = new ArrayList<Account>();
	static Scanner sc = new Scanner(System.in);
	static Controller controller = new Controller();
	static Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{6,}$"); 
	static Pattern p1 = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@$!%*#?&]])[A-Za-z\\d@$!%*#?&]{8,}$"); 
	public static void main(String[] args) throws IOException {
	
		int choose = 0;
		do {
			System.out.println("1) Create new account");
			System.out.println("2) Login to an exitsting account");
			System.out.println("3) Sort accounts by username");
			System.out.println("4) Exit");
			System.out.print("You choose : ");
			choose = sc.nextInt();
			switch(choose) {
				case 1:
					create();
					break;
				case 2:
					login();
					break;
				case 3:
					sortUserName();
					break;
				case 4:
					System.out.println("Exit successful ");
					break;
				default:
					System.out.println("You made a wrong choice, please choose again !!!");		
			}
		}while(choose != 4);
	}
	
	private static void sortUserName() {
		Collections.sort(account);
		for(Account a : account) {
				System.out.println(a.toString());
		}
		
	}

	private static void create()  {
		Account a = new Account();
		a.input();	
		if(isContain(a.getId())) {
	            System.out.println("Duplicate id");
	            return;
	     }
	    account.add(a);
	    controller.WriteAccountToFile("Account.txt", a);
	    
	}

	
	private static void login() {
//		account = controller.ReadAccountFromFile("Account.txt");
		String username;
		String password;	
		// dc r nhung ma van bug, bug o dau // ví dụ nhá
//		account = controller.ReadAccountFromFile("Account.txt");
		// thayas looxi ch chưa ảo vch
		// de t thu xem
		// vua sua dau ao the
		// nhugn van k dc dde 
		System.out.print("Enter Username: "); sc.nextLine() ; username = sc.nextLine();
        System.out.print("Enter Password: ");  password = sc.nextLine();
        
        if(checkUsernamePassLogin(username, password)) {
        	do { 
	        	System.out.println("1. Show info.       ");
	    		System.out.println("2. Change password. ");
	    		System.out.println("3. Log out          ");
	    		System.out.print("Inviting you to choose: ");
	    		int choose = sc.nextInt();
	    		sc.nextLine();
	    		Account change = saveLoginAccount(username);
	    		switch(choose) {
		    		case 1:
		    			System.out.println(change.toString());
		    			System.out.println();
		                break;
		            case 2:
		                changePassword(username, password, change);		                
		                break;
		            case 3:
		                return;
		            default: 
		            	System.out.println("Invalid selection!\n");
	    		}
        	}while(true);
        }
        else 
        	System.out.println("Username or password incorrect!");
	
	}
	
	
	private static void changePassword(String un, String pw, Account a) {
		String newPassWord, oldPassWord, confirmPassWord;
		
		// Enter old password
		do {
			System.out.print("Enter old password: "); oldPassWord = sc.nextLine();
			
			if(oldPassWord.compareTo(pw)!=0) {
				System.out.println("\nOld password is incorrect, re-enter !!!");
			}
			else
				break;
		}while(true);
		
		// Enter new password
		do {
			System.out.print("Enter new password: "); newPassWord = sc.nextLine();
			
			if(newPassWord.compareTo(pw)==0) {
				System.out.println("\n The old password is the same as the new password !!!");
			}
			else
				break;
		}while(true);
		
		// Confirm new password
		
		do {
			System.out.print("Enter new password again : "); confirmPassWord = sc.nextLine();
			
			if(confirmPassWord.compareTo(newPassWord)==0) {
				System.out.println("\n Password has been changed");
				break;
			}
			else
				System.out.println("\n Does not match new password, re-enter");
		}while(true);
		
		a.setPassword(newPassWord);
		for(Account ac : account ) {
			if(ac.getUserName().compareTo(un)==0){
				ac.setPassword(newPassWord);
			}
		}
		controller.UpdateAccountFile(account, "Account.txt");
		
	}

	public static Account saveLoginAccount(String username) {
		for (int i = 0; i < account.size(); i++)
			if (account.get(i).getUserName().compareTo(username) == 0)
				return account.get(i);
		return null;
	}
	
	private static boolean checkUsernamePassLogin(String username, String password) {
//		for(Account o: account) {
//			if(o.getUserName().compareTo(username)==0 && o.getPassword().compareTo(password)==0) {
//				return true;
//			}
//		}
		account = controller.ReadAccountFromFile("Account.txt");
		for(Account o: account) {
			if(o.getUserName().compareTo(username)==0 && o.getPassword().compareTo(password)==0) {
				return true;
			}
		}
		return false;
	}

	private static boolean isContain(long id) {
		for(Account a : account) {
			if(a.getId() == id) {
				return true;
			}
		}
		return false;
	}

	
}
