package com.reverseofnumber;

import java.util.Scanner;

public class ReverseOfNumber {
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Number");
		int n=scanner.nextInt();
		scanner.close();
		int result=calSumOfDigits(n);
		System.out.println("The Reverse of the Number "+n+" is:"+result);
		if(result==n) {
			System.out.println("\nThe Number is Palindrome");
		} else {
			System.out.println("\nThe Number is Not Palindrome");
		}
	}
	public static int calSumOfDigits(int n) {
		int rev=0,d=0;
		while(n!=0) {
			d=n%10;
			n=n/10;
			rev=rev*10+d;
		}
		return rev;
	}
}
