package com.java.aop02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/java/aop02/appCTX.xml");
		
		Person m = (Person) ctx.getBean("mom");
				
		m.work();
		
		Person p = (Person) ctx.getBean("papa");
				
		p.work();
		
		Person b = (Person) ctx.getBean("baby");
				
		b.work();
		
		ctx.close();
		
	}

}
