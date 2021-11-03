package Bai1;

import java.util.Scanner;
public class Sach {

	private String Masach;
	private String Tensach;
	private String Nxb;
	private int Sotrang;
	private double Giatien;
	
	public void nhap() {
		Scanner  sc = new Scanner(System.in);
		System.out.print("Nhap  ma sach: ");
		Masach  = sc.nextLine();
		System.out.print("Nhap  ten sach: ");
		Tensach = sc.nextLine();
		System.out.print("Nhap  nxb sach: ");
		Nxb     = sc.nextLine();
		System.out.print("Nhap  so trang: ");
		Sotrang = sc.nextInt();
		System.out.print("Nhap  gia tien: ");
		Giatien = sc.nextDouble();	
//		sc.next();
	}
	public void xuat(){
		System.out.println("Ma sach: " + Masach);
		System.out.println("Ten sach: " + Tensach);
		System.out.println("Nxb sach: " + Nxb);
		System.out.println("So trang: " + Sotrang);
		System.out.println("Gia tien: " + Giatien);
		System.out.println();
	}

}
