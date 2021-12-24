package Bai1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java.util.regex.*;

public class Account implements Comparable<Account>{
	private long id;
	private String fullName;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private String createAt;
	
	
	public Account(long id, String fullName, String userName, String password, String email, String phone,
			String createAt) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.createAt = createAt;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + " | fullName=" + fullName + " | userName=" + userName + " | password=" + password
				+ " | email=" + email + " | phone=" + phone + " | createAt=" + createAt + "]";
	}
	
	public void input() {
		Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{6,}$"); 
		Pattern p1 = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@$!%*#?&]])[A-Za-z\\d@$!%*#?&]{8,}$"); 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter id       : "); this.id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter fullname : "); this.fullName = sc.nextLine();
		System.out.print("Enter username : "); this.userName = sc.nextLine();
		if(!p.matcher(userName).find()) {
			System.out.println("Invalid username");
			return ;
		}
		System.out.print("Enter password : "); this.password = sc.nextLine();
		if(!p.matcher(userName).find()) {
			System.out.println("Invalid password");
			return ;
		}
		System.out.print("Enter email    : "); this.email = sc.nextLine();
		System.out.print("Enter phone    : "); this.phone = sc.nextLine();
		Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	this.createAt = formatter.format(date);
        
	}
	
	@Override
	public int compareTo(Account o) {
		return this.getUserName().compareTo(o.userName);
	}
}
