package Bai2;

import java.util.Scanner;
public class RunMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = null;

	}
	public static void Nhap(int[]a, int n) {
		Scanner sc  = new Scanner(System.in);
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
	}
	public static void Xuat(int[]a, int n) {
		for(int i=0; i<n; i++) {
			System.out.println(a[i]+ " ");
		}
	}
}
