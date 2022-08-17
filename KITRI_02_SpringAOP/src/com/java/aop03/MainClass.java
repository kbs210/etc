package com.java.aop03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/java/aop03/appCTX.xml");
		
		
		Person s = (Person) ctx.getBean("student");
		Person t = (Person) ctx.getBean("teacher");
		
		
		s.work();
		
		System.out.println();
		
		t.work();
		
		
		ctx.close();
		
	}

}
