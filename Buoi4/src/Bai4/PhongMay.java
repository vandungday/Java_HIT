package Bai4;
import java.util.Scanner;
public class PhongMay {
	private String maPhong;
	private String tenPhong;
	private float dienTich;
	private QuanLy x;
	private May[] y;
	private int n;
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma phong: ");
		maPhong = sc.nextLine();
		System.out.println("Nhap ten phong: ");
		tenPhong = sc.nextLine();
		System.out.println("Nhap dien tich: ");
		dienTich = sc.nextFloat();
		x = new QuanLy();
		x.Nhap();
		System.out.println("Nhap so luong may: ");
		n = sc.nextInt();
		y = new May[n];
		for(int i=0; i<n; i++) {
			y[i] = new May();
			System.out.println("Nhap thong tin may thu " +(i+1));
			y[i].Nhap();
		}
	}
	public void Xuat() {
		System.out.println("Ma phong : " + maPhong);
		System.out.println("Ten phong: " + tenPhong );
		System.out.println("Dien tich: " + dienTich);
		x.Xuat();
		 System.out.printf("%-10s %-20s %-10s \n", "Ma may", "Kieu may", "Tinh trang");
		for(int i=0; i<n; i++) {
			y[i].Xuat();
		}
	}
}
