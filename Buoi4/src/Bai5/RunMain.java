package Bai5;

public class RunMain {
	
	 public static boolean isPrimeNumber(int n) {
		 if(n<2) return false;
		 for(int i=2; i*i<=n; i++) {
			 if(n%i==0) return false;
		 }
		 return true;
	 }
	 public static boolean isPrimeNumber(long n) {
		 if(n<2) return false;
		 for(int i=2; i*i<=n; i++) {
			 if(n%i==0) return false;
		 }
		 return true;
	 }
	 public static boolean isPrimeNumber(double n) {
		 if(n - (int)n != 0) {
			 return false;
		 }
		 else {
			 n = (int)n;
			 if(n<2) return false;
			 for(int i=2; i*i<=n; i++) {
				 if(n%i==0) return false;
			 }
			 return true;
		 }
}
	 public static boolean isPrimeNumber(float n) {
		 if(n - (int)n != 0) {
			 return false;
		 }
		 else {
			 n = (int)n;
			 if(n<2) return false;
			 for(int i=2; i*i<=n; i++) {
				 if(n%i==0) return false;
			 }
			 return true;
		 }
	 }
	    public static void main(String[] args) {
	        System.out.println(isPrimeNumber(17));
	        System.out.println(isPrimeNumber(1000000000000001L));
	        System.out.println(isPrimeNumber(2.000));
	        System.out.println(isPrimeNumber(2.333333333333333333f));
	    }

}
