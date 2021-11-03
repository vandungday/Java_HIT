package Bai4;

import java.util.Scanner;
public class QuanLy {
    private String maQL;
    private String hoTen;
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ma quan li: ");
        maQL = sc.nextLine();
        System.out.println("Ho ten: ");
        hoTen = sc.nextLine();
    }
    public void Xuat(){
        System.out.println("Ma quan li: " + maQL);
        System.out.println("Ho ten: " + hoTen);
    }
}
