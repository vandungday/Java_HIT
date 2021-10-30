package Bai1;
/*
Bài 1: Khai báo lớp Person gồm các thuộc tính: name, age, gender, hobby. 
Yêu cầu:
	+ Dùng constructor để khởi tạo 1 đối tượng với đầy đủ thuộc tính và toString() để hiển thị thông tin đối tượng 
	+ Sử dụng setter, getter nhập xuất thông tin cho 1 person và xuất thông tin 1 person trên.
*/
import java.util.Scanner;
public class Bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person ps = new Person("Dung", 19, "Nam", "Doc");
		System.out.println(ps);
		
		Person psA = new Person();
		System.out.print("Enter name: ");
		psA.setName(sc.nextLine()); 
		System.out.print("Enter age: ");
		psA.setAge(sc.nextInt()); sc.nextLine();
		System.out.print("Enter gender : ");
		psA.setGender(sc.nextLine());
		System.out.print("Enter hobby: ");
		psA.setHobby(sc.nextLine());
		System.out.println(psA);
		
	}
}
