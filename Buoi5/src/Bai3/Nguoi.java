package Bai3;

import java.util.Scanner;
public class Nguoi {
	protected String HoTen;
	protected String NgaySinh;
	protected String QueQuan;
	public Nguoi(){
		this.HoTen    =  "";
		this.NgaySinh =  "";
		this.QueQuan  =  "";
	}
	public Nguoi(String HoTen, String NgaySinh, String QueQuan) {
		this.HoTen    = HoTen;
		this.NgaySinh = NgaySinh;
		this.QueQuan  = QueQuan;
	}
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho ten   : ");
		HoTen = sc.nextLine();
		System.out.println("Nhap ngay sinh: ");
		NgaySinh = sc.nextLine();
		System.out.println("Nhap que quan : ");
		QueQuan = sc.nextLine();
	}
	public void Xuat() {
		System.out.printf("%-20s %-20s %-20s ", HoTen, NgaySinh, QueQuan);
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getQueQuan() {
		return QueQuan;
	}
	public void setQueQuan(String queQuan) {
		QueQuan = queQuan;
	}

}