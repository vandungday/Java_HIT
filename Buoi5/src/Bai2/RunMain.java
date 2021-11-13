package Bai2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class RunMain {
	public static void main(String[] args) {
	
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Nhap so luong: ");
	        int n = sc.nextInt();

	        ArrayList<DieuHoa> x = new ArrayList<>();
	        for(int i = 0; i < n; i++){
	            DieuHoa y = new DieuHoa();
	            System.out.println("\tNhap thong tin dieu hoa  thu: " + (i + 1));
	            y.Nhap();
	            x.add(y);
	        }
	        System.out.printf("%-20s %-20s %-20s %-20s %-18s %-18s", 
	        		"Ma", "Ten", "Ten Hang", "Ngay Nhap", "Cong Suat","Gia Ban" );
	        System.out.println("");
	        for(int i=0; i<n; i++) {
	        	x.get(i).Xuat();
	        }
	        
	        System.out.println("Cac san pham co ten hang la Electrolux: ");
	        DieuHoa min = x.get(0);
	        int dem = 0;
	        for(int i=0; i<n; i++){
	            if(x.get(i).getTenHangSX().compareToIgnoreCase("Electrolux")==0){
	                dem++;
	            }
	            if(x.get(i).getGiaBan()<min.getGiaBan()){
	                min=x.get(i);
	            }

	        }
	        if(dem==0){
	            System.out.println("Khong co hang Electrolux");
	        }
	        else {
	        	  System.out.printf("%-20s %-20s %-20s %-20s %-18s %-18s\n", 
	  	        		"Ma", "Ten", "Ten Hang", "Ngay Nhap", "Cong Suat","Gia Ban" );
	        	   for(int i=0; i<n; i++){
	   	            if(x.get(i).getTenHangSX().compareToIgnoreCase("Electrolux")==0)
	   	                x.get(i).Xuat();
	        	   }
	        }
	        System.out.println("Thong tin dieu hoa co gia thap nhat la:");
	        System.out.printf("%-20s %-20s %-20s %-20s %-18s %-18s\n", 
	        		"Ma", "Ten", "Ten Hang", "Ngay Nhap", "Cong Suat","Gia Ban" );
	        min.Xuat();
	        

	}
}
