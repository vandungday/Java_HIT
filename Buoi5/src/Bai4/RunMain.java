package Bai4;

import java.util.Scanner;
public class RunMain {
	public static void main(String[] args) {
		
	 Sum <Integer> a = new Sum<Integer>(1, 2);
     System.out.println("Sum 1: " + (a.getSoB()+a.getSoA()));
     Sum <Long> b = new Sum<Long>(123467L, 7654321L);
     System.out.println("Sum 2: "+ (b.getSoA() +b.getSoB()));
     Sum <Float> c = new Sum<Float>(1.2f, 3.4f);
     System.out.println("Sum 3: "+ (c.getSoB() +c.getSoA()));
     Sum <Double> d = new Sum<Double>(3.33333333333, 2.22222222222);
     System.out.println("Sum 4: " + (d.getSoA() +d.getSoB()));
	}
}
