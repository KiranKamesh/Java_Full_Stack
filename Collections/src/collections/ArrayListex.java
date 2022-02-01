package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1111);
		a1.add(222);
		a1.add(3333);
		a1.add(4444);
		a1.add(32);
		a1.add(455);
		
		System.out.println("Before sorting");
		for(int i: a1){
			System.out.print(i+" ");
		}
		System.out.println();
		
		Collections.sort(a1);
		System.out.println("After sorting");
		for(int i: a1){
			System.out.print(i+" ");
		}
		
		ArrayList<Integer> a2 = new ArrayList<Integer>(5);
		for(int i = 0;i<a2.size();i++){
			a2.add(i*2);
		}
		
		System.out.println("second Arraylist ");
		for(int i: a2){
			System.out.print(i+" ");
		}
		System.out.println();
		
		a2.addAll(a1);
		
		System.out.println("second arraylist after adding first arraylist");
		for(int i: a2){
			System.out.print(i+" ");
		}
		
	}

}
