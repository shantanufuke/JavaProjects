package com.primefactorization;

public class PrimeFactorization extends StackImplementation {
	public void calculatePrimeFactorization(int n) {
		while(n!=1) {
			for(int i = 2; i<= n; i++) {
				if(n%i==0) {
					this.push(i);
					n=n/i;
					break;
				}
			}
	   }
	}
	
	public void displayFactorization() {
		StringBuilder factors=new StringBuilder();
		while(top!=-1) {
			factors.append(super.top()).append(" ");
			super.top();
			super.pop();
		}
		System.out.println("\033[1mThe Prime Factors of Number: \033[0m "+factors);
	}
}
