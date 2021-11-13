package Bai1;


import java.util.Scanner;
public class SanPham {
	private String MaSP;
	private String TenSP;
	private int SoLuong;
	private double DonGia;
	public void InputSP() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma san pham: ");
		MaSP = sc.nextLine();
		System.out.println("Nhap ten san pham: ");
		TenSP = sc.nextLine();
		System.out.println("Nhap so luong san pham: ");
		SoLuong = sc.nextInt();
		System.out.println("Nhap don gia san pham: ");
		DonGia = sc.nextFloat();
	}
	public void OutputSP() {
		System.out.printf(" %-20s %-20s %-20s %-20.3f %-20.3f \n", MaSP, TenSP, SoLuong, DonGia, SoLuong*DonGia);
	}
}
	
