package Bai4;

import java.util.Scanner;


public class May {
    private String maMay;
    private String kieuMay;
    private String tinhTrang;
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ma may: ");
        maMay = sc.nextLine();
        System.out.println("Kieu may: ");
        kieuMay = sc.nextLine();
        System.out.println("Tinh trang: ");
        tinhTrang = sc.nextLine();
    }
    public void Xuat(){
        System.out.printf("%-10s %-20s %-10s \n", maMay, kieuMay, tinhTrang);
    }
}