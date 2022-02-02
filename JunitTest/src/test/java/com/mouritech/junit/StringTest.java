package com.mouritech.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {

	Text t = new Text();
	@Test
	public void testMessage() {
		assertSame("hello", t.message());
		assertEquals("hello",t.message());
	}

}