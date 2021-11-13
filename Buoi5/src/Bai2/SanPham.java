package Bai2;

import java.util.Scanner;

public class SanPham {
    protected String MaSanPham, TenSanPham, TenHangSX, NgayNhap;

    public SanPham(){
    }

    public SanPham(String maSanPham, String tenSanPham, String tenHangSX, String ngayNhap) {
        this.MaSanPham = maSanPham;
        this.TenSanPham = tenSanPham;
        this.TenHangSX = tenHangSX;
        this.NgayNhap = ngayNhap;
    }

    public void Nhap(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma san pham: ");
        MaSanPham =  sc.nextLine();

        System.out.print("Nhap ten san pham: ");
        TenSanPham =  sc.nextLine();

        System.out.print("Nhap ten hang san xuat: ");
        TenHangSX =  sc.nextLine();

        System.out.print("Nhap ngay nhap: ");
        NgayNhap = sc.nextLine();
    }
    public void Xuat() {
    	System.out.printf("%-20s %-20s %-20s %-20s", MaSanPham, TenSanPham, TenHangSX, NgayNhap);
    }

	public String getMaSanPham() {
		return MaSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return TenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}

	public String getTenHangSX() {
		return TenHangSX;
	}

	public void setTenHangSX(String tenHangSX) {
		TenHangSX = tenHangSX;
	}

	public String getNgayNhap() {
		return NgayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		NgayNhap = ngayNhap;
	}
    
}