package com.primefactorization;

public class StackImplementation {
	protected int [] arrStack=new int[100];
	protected int top;

	public StackImplementation() {
		top=-1;
	}
	
	public boolean isFull() {
		if(top==arrStack.length-1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if(top==-1) 
			return true;
		return false;
	}
	
	public void push(int element) {
		if(isFull())  {
			System.out.println("Stack is Full");
		} else {
			top=top+1;
			arrStack[top]=element;
		}
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		} else {
			top=top-1;
		}
	}
	
	public int top() {
		if(isEmpty() ) {
			System.out.println("Stack is Empty");
			return 0;
		} else {
			return arrStack[top];
		}
	}
	
	 public void result() {
		System.out.println("Result: "+arrStack);
	}
}


