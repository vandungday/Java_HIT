package Bai3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class LopHoc {
	private String MaLH;
	private String TenLH;
	private String NgayMo;
	private ArrayList<SinhVien> x;
	int n;
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma lop : ");
		MaLH = sc.nextLine();
		System.out.println("Nhap ten lop: ");
		TenLH = sc.nextLine();
		System.out.println("Nhap ngay mo: ");
		NgayMo = sc.nextLine();
		System.out.println("Nhap so luong sinh vien: ");
		n = sc.nextInt();
		sc.nextLine();
		x = new ArrayList<> ();
		for(int i=0; i<n; i++)
		{
			SinhVien y = new SinhVien();
			System.out.println("Nhap thong tin sinh tien thu " + (i+1));
			y.Nhap();
			x.add(y);
		}
	}
	public void Xuat() {
		System.out.println("=================THONG TIN CUA LOP HOC=================");
		System.out.println("Ma lop : " + MaLH);
		System.out.println("Ten lop: " + TenLH);
		System.out.println("Ngay mo: " + NgayMo);
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s"
				,"Ho ten","Ngay sinh", "Que quan","Ma SV","Nganh","Khoa" );
		System.out.println("");
		for(int i=0; i<n ;i++) {
			x.get(i).Xuat();
			System.out.println("");
		}
	}
	public void K15() {
		int count=0;
		for(int i=0; i<n; i++) {
			if(x.get(i).getKhoa()==15)
				count++;
		}
		System.out.println("Co "+ count + " sinh vien khoa 15");
	}
    public void SapXep(){
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++)
                if(x.get(i).getKhoa()> x.get(j).getKhoa())
                    Collections.swap(x, i, j);
        }
    }
}	