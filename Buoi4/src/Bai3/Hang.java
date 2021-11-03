package Bai3;

import java.util.Scanner;


public class Hang {
    private String Mahang;
    private String Tenhang;
    private float Dongia;
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma hang: ");
        Mahang  = sc.nextLine();
        System.out.print("Ten hang: ");
        Tenhang = sc.nextLine();
        System.out.print("Don gia: ");
        Dongia  = sc.nextFloat();
    }
    public void Xuat(){
        System.out.printf("%-10s %-20s %-10.3f \n", Mahang, Tenhang, Dongia);
    }
            
}