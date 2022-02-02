package com.mouritech.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdditionTest {

	Addition ad = new Addition();
	@Test
	public void addTest(){
		System.out.println(ad.add(20, 10));
		assertEquals(20, ad.add(10, 10));
		
	}
	
	@Test
	public void addTest1(){
		assertEquals(50, ad.add(50, 10));
	}
}
