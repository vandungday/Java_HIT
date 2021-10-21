package Bai4;

import java.util.Scanner;
public class RunMain {
	public static void main(String[] args) {
		System.out.print("Nhap chuoi: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
//		Xóa khoảng trắng thừa ở đầu và cuối
		s = s.trim();
//		Giữa các từ chỉ có 1 khoảng trắng
		s = s.replaceAll("\\s+"," ");
//		Xóa các ký tự số
		s = s.replaceAll("[\\d.]","");
//		Viết hoa các chữ cái đầu
	    char[] charArray = s.toCharArray();
	    boolean foundSpace = true;
	    for(int i = 0; i < charArray.length; i++) {
	      if(Character.isLetter(charArray[i])) {
	        if(foundSpace) {
	          charArray[i] = Character.toUpperCase(charArray[i]);
	          foundSpace = false;
	        }
	      }
	      else {
	        foundSpace = true;
	      }
	    }
	    s = String.valueOf(charArray);
	    System.out.println("Chuoi sau khi chuan hoa la: " +s);
	}
}
