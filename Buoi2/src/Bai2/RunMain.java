package Bai2;

import java.util.Scanner;
import java.lang.Math;
public class RunMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong phan tu cua mang: ");
		int n = sc.nextInt();
		int[] a = new int[n+1];
		while(true) {
			System.out.println("1. Nhap mang");
			System.out.println("2. Xuat mang");
			System.out.println("3. Them phan tu");
			System.out.println("4. Xoa phan tu");
			System.out.println("5. Mang dao nguoc");
			System.out.println("6. Hien thi a[1] va cac so chia het cho a[1]");
			System.out.println("7. Tong cac so nguyen to");
			System.out.println("8. Thoat chuong trinh");
			System.out.print("Moi ban chon: ");
			int choose = sc.nextInt();
			switch (choose) {
				case 1:
					Nhap(a,n);
					break;
				case 2:
					System.out.print("Mang vua nhap la: ");
					Xuat(a,n);
					break;
				case 3:
					Them(a,n);
					break;
				case 4:
					Xoa(a,n);
					break;
				case 5:
					Dao(a,n);
					break;
				case 6:
					A1(a,n);
					break;
				case 7:
					KT(a,n);
					break;
				case 8:
					return;
				default:
					System.out.println("Nhap lai!");
			}
			
		}
	}
	
	public static void Nhap(int[]a, int n) {
		Scanner sc  = new Scanner(System.in);
		for(int i=0; i<n; i++) {
			System.out.print("Nhap a["+ i +"] :");
			a[i] = sc.nextInt();
			
		}
	}
	public static void Xuat(int[]a, int n) {
		for(int i=0; i<n; i++)
			System.out.print(a[i]+ " ");
		System.out.println("");
	}
	public static void Xoa(int[]a, int n) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap phan tu muon xoa: ");
		int pos = sc.nextInt();
		for(int i =pos-1; i <n-1 ;i++ ) {
			a[i]= a[i+1];
		}
		n--;
		System.out.print("Mang sau khi xoa la: ");Xuat(a,n);
	}
	public static void Them(int[]a, int n) {
		Scanner sc = new Scanner(System.in);
		int[] b = new int[n+1];
		System.out.print("\nNhap vi tri chen: ");
		int pos = sc.nextInt();
		System.out.print("Nhap gia tri chen: "); 
		int x = sc.nextInt();
		int j=0;
		for(int i=0; i < n+1; i++ ) {
			if(i==pos-1) 
				b[i] = x;
			else 
				b[i]= a[j++];
		}
		System.out.print("Mang sau khi chen la: "); Xuat(b,n+1);
	}
	public static void Dao(int[]a, int n) {
		System.out.print("\nMang doi chieu la: ");
		for(int i=n-1; i>=0; i--) {
			System.out.print(a[i]+ " ");
		}
		System.out.println("");
	}
	public static void A1(int[]a, int n) {
		int temp = a[1];
		System.out.print("So a[1] la: " + temp);
		System.out.print("\nCac so chia het cho a[1] la: ");
		for(int i=0;i <n; i++) {
			if(a[i]%temp==0) {
				System.out.print(a[i]+ " ");
			}
		}
		System.out.println("");
	}
	public static boolean SNT(int n) {
		if(n<2) return false;
		for(int i=2; i*i<=n; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	public static void KT(int[]a, int n) {
		int sum = 0;
		for(int i=0; i<n; i++) {
			if(SNT(a[i])) {
				sum+=a[i];
			}
		} 
		System.out.println("Tong SNT trong mang la: " + sum);
	}
	
}