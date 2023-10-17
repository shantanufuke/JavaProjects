package com.sumofdigits;

import java.util.Scanner;

public class SumOfDigits {
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Number");
		int n=scanner.nextInt();
		scanner.close();
		int result=calSumOfDigits(n);
		System.out.println("The sum of Digits of the Number "+n+" is:"+result);
	}
	public static int calSumOfDigits(int n) {
		int sum=0,d=0;
		while(n!=0) {
			d=n%10;
			n=n/10;
			sum=sum+d;
		}
		return sum;
	}
}
