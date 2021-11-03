package Bai1;

import java.util.Scanner;
public class RunMain {
	public static void main(String[] args) {
		int n;
		Scanner  sc = new Scanner(System.in);
		System.out.print("Nhap so luong sach: ");
		n = sc.nextInt();
		Sach[] s = new Sach[n];
		for(int i=0; i<n; i++) {
			s[i] = new Sach();
			System.out.println("Nhap thong tin cuon sach thu " + (i+1));
			s[i].nhap();
		}
		for(int i=0; i<n; i++) {
			System.out.println("Thong tin cuon sach thu "+ i);
			s[i].xuat();
		}
	}
}
