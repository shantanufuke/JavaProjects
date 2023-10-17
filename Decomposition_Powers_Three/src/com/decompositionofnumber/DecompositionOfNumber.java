package com.decompositionofnumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DecompositionOfNumber {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n=scanner.nextInt();
		scanner.close();
		performDecomposition(n);
	}	
		
	public static void performDecomposition(int n) {
		boolean checkPositiveNumber=true;
		if(n<0) {
			checkPositiveNumber=false;
			n=-n;
		}
		
		ArrayList<Integer> outputDecomposition=new ArrayList<Integer>();
		int temp=0,sumOfSeries=0;
		int originalNumber=n;
		while(sumOfSeries!=originalNumber) {
			temp=decomposeTheNumber(n);
			if(outputDecomposition.contains(temp)|| outputDecomposition.contains(-temp)) {
				continue;
			}
			int sum = 0;
			for(int i = 0; i < outputDecomposition.size(); i++)
			    sum += outputDecomposition.get(i);
			
			if(sum>originalNumber) {
				temp=-temp;
			} else {
				temp=temp;
			}

			sumOfSeries=sumOfSeries+temp;
			outputDecomposition.add(temp);
			if(temp>0) {
				n=temp-n;
			} else {
				n=(-temp)-n;
			}
			if(n<0) 
				n=(-1)*n;
		}
		
		if(checkPositiveNumber==false) {
			int element=0;
			for(int i = 0; i < outputDecomposition.size(); i++) {
			   element=outputDecomposition.get(i);
			   if(element>0) {
				   outputDecomposition.set(i, (-1*element));
			   } else {
				   outputDecomposition.set(i, (-1*element));
			   };
			}
		}
		System.out.println(outputDecomposition);
	}	

	
	public static int decomposeTheNumber(int n) {
		int [] powersOfThree = {1,3,9,27,81};
		int length=powersOfThree.length;
		int sum=0,result=0;
		for(int i=0;i<length;i++){
			if(powersOfThree[i]>=sum){
				sum=sum+powersOfThree[i];
				if(n<=sum) {
					return powersOfThree[i];
				}
			} 
		}
		
		return result;
	}
}
