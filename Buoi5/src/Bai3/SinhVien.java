package Bai3;

import java.util.Scanner;
public class SinhVien extends Nguoi{
	private String MaSV;
	private String Nganh;
	private int Khoa;
	public SinhVien() {
		this.HoTen    = "";
		this.NgaySinh = "";
		this.QueQuan  = "";
        this.Khoa     =  0;
        this.MaSV     =  "";
        this.Nganh    =  "";
	}
	public SinhVien(String HoTen, String NgaySinh, String QueQuan, String MaSV, String Nganh, int Khoa) {
        super(HoTen, NgaySinh, QueQuan);
        this.MaSV = MaSV;
        this.Nganh = Nganh;
        this.Khoa = Khoa;
    }
	
	
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		super.Nhap();
		System.out.println("Nhap ma sv   : "); 
		MaSV = sc.nextLine();
		System.out.println("Nhap nganh   : ");
		Nganh = sc.nextLine();
		System.out.println("Nhap khoa hoc: ");
		Khoa = sc.nextInt();
	}
	public void Xuat() {
		super.Xuat();
		System.out.printf(" %-20s %-20s %-20s ", MaSV, Nganh, Khoa);
	}
	public String getMaSV() {
		return MaSV;
	}
	public void setMaSV(String maSV) {
		MaSV = maSV;
	}
	public String getNganh() {
		return Nganh;
	}
	public void setNganh(String nganh) {
		Nganh = nganh;
	}
	public int getKhoa() {
		return Khoa;
	}
	public void setKhoa(int khoa) {
		Khoa = khoa;
	}

}