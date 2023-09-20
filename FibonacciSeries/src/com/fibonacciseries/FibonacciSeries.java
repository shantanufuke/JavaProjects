package com.fibonacciseries;

import java.util.Scanner;

public class FibonacciSeries {
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter The Number");
		int n=scanner.nextInt();
		scanner.close();
		System.out.println("Generating Fibonacci Series Till "+n);
		generateSeries(n);
		
	}

	private static void generateSeries(int n) {
		int f1=0,f2=1,f3;
		System.out.print(f1+" ");
		System.out.print(f2+" ");
		for(int i=3;i<=n;i++) {
			f3=f1+f2;
			System.out.print(f3+" ");
			f1=f2;
			f2=f3;
		}
		
	}
}
