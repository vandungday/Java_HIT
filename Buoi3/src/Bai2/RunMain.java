package Bai2;

import java.util.Scanner;
public class RunMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Array a = new Array();
		a.inputData();
		System.out.print("Mang vua nhap la: "); a.Show();
		System.out.println("Tong phan tu cua mang la: " + a.Sum());
		System.out.print("Nhap flag: ");
	    Boolean flag ;
	    flag = sc.nextBoolean();
	    a.Filter(flag);
	    System.out.println();
		
		Array b = new Array();
		b.inputData();
		System.out.print("Mang vua nhap la: "); b.Show();
		System.out.println("Tong phan tu cua mang la: " + b.Sum());
		System.out.print("Nhap flag: ");
		flag = sc.nextBoolean();
		b.Filter(flag);
		System.out.println();
		
		if((double)a.Sum()/a.getN() > (double)b.Sum()/b.getN()) {
			System.out.println("TBC a lon hon");
		}
		else if((double)a.Sum()/a.getN() < (double)b.Sum()/b.getN()){
			System.out.println("TBC b lon hon");
		}
		else 
			System.out.println("Bye");
		
	}
	
}
