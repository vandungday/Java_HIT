package Bai3;

import java.util.Scanner;
public class RunMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String s = sc.nextLine();
		System.out.println("Chuoi vua nhap la: " + s );
		int count = 0, sum = 0;
		for(int i=0; i< s.length(); i++) {
			if(s.charAt(i)>=48 && s.charAt(i) <=57) {
				count++;
				sum+=s.charAt(i) - 48;	
			}
		}
		if(count!=0) {
			System.out.println("True");
			System.out.println("Trung binh cong cac chu so trong chuoi la: " + (float)sum/count);			
		}
		else {
			System.out.println("False");
			System.out.println("Trung binh cong cac chu so trong chuoi la: " + 0);			
		}
	}
}
