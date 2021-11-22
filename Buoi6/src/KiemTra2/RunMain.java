package KiemTra2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.IllegalFormatConversionException;
public class RunMain {
	static Scanner sc = new Scanner(System.in);
	static ArrayList <Book> book = new  ArrayList <> ();
	public static void main(String[] args) {
		
		Book a = new Book();
		String choose = null;
		 boolean exit = false;
		Nhap(a);
		Xuat(a);
		showMenu();
		while(true) {
			choose = sc.nextLine();
			switch (choose) {
            case  "1":
            	Add();
                break;
            case "2":
               
                break;
            case "3":
            	System.out.println("Nhập id cần xóa: ");
            	String id =sc.nextLine();
            	Delete(id);
                break;
            case "4":
                
                break;
            case "5":
              
                break;
            case "6":
             
                break;
            case "0":
                System.out.println("exited!");
                exit = true;
                break;
            default:
                System.out.println("invalid! please choose action in below menu:");
                break;
            }
            if (exit) {
                break;
            }
 
            showMenu();
		}
	}
	
	public static void Nhap(Book a) {
		int n;
		System.out.println("Nhâp số lượng sách: ");
		n = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<n; i++) {
			a = new Book ();
			System.out.println("Nhập thông tin quyển sách thứ " + (i+1));
			System.out.print("Nhâp ID          : "); a.setId(sc.nextLine());
			System.out.print("Nhâp tên sách    : "); a.setName(sc.nextLine());
			System.out.print("Nhâp nhà xuất bản: "); a.setPublisher(sc.nextLine());
			System.out.print("Nhâp giá         : "); a.setPrice(sc.nextFloat());
			System.out.print("Nhâp số trang    : "); a.setNumberOfPage(sc.nextInt());
			sc.nextLine();
			System.out.print("Nhâp tác giả     : "); a.setAuthor(sc.nextLine());
			book.add(a);
		}
		
	}
		
	public static void Xuat(Book a) {
		
		   System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n",
				   "ID", "Tên", "NSB", "Giá", "Số Trang", "Tác Giả");
		   for(Book i: book) {
			   System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n",
					   i.getId(), i.getName(), i.getPublisher(), i.getPrice(), i.getNumberOfPage()
					   , i.getAuthor());
		   }
	}
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add book.");
        System.out.println("2. Edit book by id.");
        System.out.println("3. Delete book by id.");
        System.out.println("4. Sort book by name.");
        System.out.println("5. Sort book by price.");
        System.out.println("6. Show all books.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
	
    public static void Add() {
        Book a = new Book ();
		System.out.print("Nhâp ID          : "); a.setId(sc.nextLine());
		System.out.print("Nhâp tên sách    : "); a.setName(sc.nextLine());
		System.out.print("Nhâp nhà xuất bản: "); a.setPublisher(sc.nextLine());
		System.out.print("Nhâp giá         : "); a.setPrice(sc.nextFloat());
		System.out.print("Nhâp số trang    : "); a.setNumberOfPage(sc.nextInt());
		sc.nextLine();
		System.out.print("Nhâp tác giả     : "); a.setAuthor(sc.nextLine());
		book.add(a);        
    }
	public static void Delete(String id) {
		for(Book i : book) {
			if(i.getId() == id) {
				book.remove(i);
			}
		}
	}
		
	
}
