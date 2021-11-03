package Bai2;
import java.util.Scanner;
public class NhanSu {
	private String Manhansu;
	private String Hoten;
	private Date ns;
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma nhan su: ");
		Manhansu = sc.nextLine();
		System.out.print("Nhap ho ten    : ");
		Hoten = sc.next();
		ns = new Date();
		ns.Nhap();
		sc.nextLine();
	}
	public void Xuat() {
		System.out.println("Ma nhan su: " + Manhansu);
		System.out.println("Ho ten    : " + Hoten);
		ns.Xuat();
	}
}
