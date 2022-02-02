package com.mouritech.junit;

public class ArraySum {
	
	public int[] arraySum(int[] a,int[] b) {
		int[] sum = new int[3];
		for(int i=0;i<a.length;i++) {
			
				sum[i] = a[i] + b[i];
			
		}
		return sum;
	}

}
