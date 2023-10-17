package com.factorial;

import java.util.Scanner;

public class Factorial {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter the Number");
	int n=scanner.nextInt();
	scanner.close();
	factorial(n);
	
}

private static void factorial(int n) {
	int factorial=1,i=1;
	while(i<=n) {
		factorial=factorial*i;
		i=i+1;
	}
	System.out.println("Factorial of Number is: "+factorial);
	
}
}
