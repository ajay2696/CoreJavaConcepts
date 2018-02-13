package com.mine.practice.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void test() {
		HelloWorld hw=new HelloWorld();
		String result =hw.sayHelloWorld();
		assertEquals("HelloWorl", result);
	}

}
