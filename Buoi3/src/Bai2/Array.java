package Bai2;

import java.util.Scanner;
public class Array {
	Scanner sc =  new Scanner(System.in);
	private int n;
	private int []a;
	
	Array(){
		
	}
	Array(int []a, int n){
		this.a=a;
		this.n=n;
	}
	public void setN(int n) {
		this.n=n;
	}
	public int getN() {
		return n;
	}
	public void setA(int []a) {
		this.a=a;
	}
	public int[] getA() {
		return a;
	}
	public void inputData() {
		System.out.print("Nhap so luong phan tu cua mang: ");
		n = sc.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++) {
			System.out.print("Nhap a["+ i +"]: ");
			a[i] = sc.nextInt();
		}
//		System.out.println();
	}
	public void Show() {
		for(int i=0; i<n; i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
	}
	public int Sum() {
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += a[i];
		}
		return sum;
	}
    public void Filter(Boolean flag) {
    	if(flag==true) {
    		System.out.print("Cac so chan trong mang la: ");
    		for(int i=0; i<n; i++) {
    			if(a[i] %2 ==0 )
    				System.out.print(a[i]+ " ");
    		}
    	}
    	else {
    		System.out.print("Cac so le trong mang la: ");
    		for(int i=0; i<n; i++) {
    			if(a[i] %2 !=0 )
    				System.out.print(a[i]+ " ");
    		}
    	}
    	System.out.println();
    }

	
}
