package Bai1;

import java.util.Scanner;
public class RunMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap n: ");
		int n = sc.nextInt();
		System.out.print("Nhap m: ");
		int m = sc.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i==0 || i== n-1) 
					System.out.print("* ");
				else if(j==0 || j==m-1) 
					System.out.print("* ");
				else 
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
