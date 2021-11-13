package Bai2;

import java.util.Scanner;
public class DieuHoa extends SanPham{
    private double CongSuat;
    private double GiaBan;

    public DieuHoa() {
    }

    public DieuHoa(String MaSanPham, String TenSanPham, String TenHangSX, String NgayNhap, double CongSuat, long GiaBan) {
        super(MaSanPham, TenSanPham, TenHangSX, NgayNhap);
        this.CongSuat = CongSuat;
        this.GiaBan = GiaBan;
    }

    public void Nhap(){
        super.Nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao cong suat: "); CongSuat = sc.nextDouble();
        System.out.print("Nhap vao giá bán: "); GiaBan = sc.nextDouble();
        sc.nextLine();
    }
    public void Xuat() {

    	super.Xuat();
    	System.out.printf("%-20s %-20s \n", CongSuat, GiaBan);
    }

	public double getCongSuat() {
		return CongSuat;
	}

	public void setCongSuat(double congSuat) {
		CongSuat = congSuat;
	}

	public double getGiaBan() {
		return GiaBan;
	}

	public void setGiaBan(double giaBan) {
		GiaBan = giaBan;
	}
    
}