package com.java.di03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("appCTX.xml");
		
		Sub s1 = (Sub) ctx.getBean("sub1");
		
		System.out.println(s1.toString());
		
		
		Sub s2 = (Sub) ctx.getBean("sub2");
		
		System.out.println(s2.toString());
	}
}
