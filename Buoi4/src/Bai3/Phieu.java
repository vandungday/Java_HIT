package Bai3;

import java.util.Scanner;
public class Phieu {
	private String Maphieu;
	private Hang []x;
	private int n;
	
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma phieu: ");
		Maphieu = sc.nextLine();
		System.out.print("Nhap so luong hang: ");
		n = sc.nextInt();
		x = new Hang[n];
		for(int i=0; i<n; i++) {
			x[i] = new Hang();
			System.out.println("Nhap thong tin hang thu "+(i+1));
			x[i].Nhap();
		}	
	}
	public void Xuat() {
	    System.out.printf("%-10s %-20s %-10s \n", "Ma hang", "Ten hang", "Don gia");
		for(int i=0; i<n; i++) {
			x[i].Xuat();
		}
	}
	
}
