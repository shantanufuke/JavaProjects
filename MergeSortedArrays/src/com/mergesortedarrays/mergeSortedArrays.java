package com.mergesortedarrays;



public class mergeSortedArrays {
	    public static int[] merge(int[] A, int[] B) {
	        int m = A.length;
	        int n = B.length;
	        int[] C = new int[m + n];
	        int i = 0, j = 0, k = 0;

	        while (i < m && j < n) {
	            if (A[i] <= B[j]) {
	                C[k] = A[i];
	                i++;
	            } else {
	                C[k] = B[j];
	                j++;
	            }
	            k++;
	        }

	        while (i < m) {
	            C[k] = A[i];
	            i++;
	            k++;
	        }

	        while (j < n) {
	            C[k] = B[j];
	            j++;
	            k++;
	        }

	        return C;
	    }

	    public static void main(String[] args) {
	    	int[] A = {12,15,20,25};
	        int[] B = {21, 43, 66, 88};
	        int[] C = merge(A, B);

	        System.out.print("Sorted array C: ");
	        for (int num : C) {
	            System.out.print(num + " ");
	        }
	    }
	}

