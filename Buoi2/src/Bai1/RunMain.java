package Bai1;

import java.lang.Math;
import java.util.Scanner;
public class RunMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so a: "); 
		int a = sc.nextInt();
		System.out.print("Nhap so b: "); 
		int b = sc.nextInt();
		System.out.print("Nhap so c: ");
		int c = sc.nextInt();
		System.out.println("Max cua ba so la: " + Max(a,b,c));
	}
	public static int Max(int a, int b, int c) {
		int max = a;
		if(a>b && a>c) max = a;
		else if(b>c) max = b;
		else max = c;
		return max;
	}
	
}
