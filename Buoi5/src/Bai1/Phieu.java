package Bai1;

import java.util.ArrayList;
import java.util.Scanner;
public class Phieu {
	private String MaPhieu;
	private String TenPhieu;
	private DateTime a;
	private ArrayList<SanPham> x;
	private int n;
	public void InputPhieu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma phieu : "); MaPhieu  = sc.nextLine();
		System.out.println("Nhap ten phieu: "); TenPhieu = sc.nextLine(); 
		a = new DateTime();
		a.InputDate();
		System.out.println("Nhap so luong san pham: "); n = sc.nextInt();
		sc.nextLine();
		x = new ArrayList<>();
		for(int i=0; i<n; i++) {
			SanPham y = new SanPham();
			System.out.println("Nhap san pham thu " +(i+1) );
			y.InputSP();
			x.add(y);
		}
	        
	}
	public void OutputPhieu() {
		System.out.println("Ma phieu : " + MaPhieu );
		System.out.println("Ten phieu: " + TenPhieu);
		a.OutputDate();
		System.out.printf(" %-20s %-20s %-20s %-20s %-20s \n", "Ma SP", "Ten SP", "So Luong", "Don Gia", "Thanh Tien");
		for(int i=0; i<n; i++) {
			x.get(i).OutputSP();
		}
	}
}
