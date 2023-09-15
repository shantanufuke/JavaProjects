package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class reprensentationNBaseB {
public static void main(String [] args)
{
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter the Number N");
	int N=scanner.nextInt();
	System.out.println("Enter the Value of B");
	int B=scanner.nextInt();
	if(B<2)
	{
		System.out.println("Please Enter the Value of B Greater than 2");
		return;
	}
	
	ArrayList<String> seriesOutput=calculateSeries(N,B);
	System.out.println("output");
	System.out.println(String.join(" + ",seriesOutput) );
}
static ArrayList<String> calculateSeries(int N,int B)
{
	ArrayList<String> terms = new ArrayList<>();
	int a=0;
	while(N>0)
	{
		a=N % B;
		terms.add(a + "*" + B + "^" + terms.size());
		N=N/B;
	}
	return terms;
}
}
