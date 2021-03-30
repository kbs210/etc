package com.java.aop01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/java/aop01/appCTX.xml");
		
		Person m = (Person) ctx.getBean("mom");
				
		m.awake();
		m.work();
		m.sleep();
		
		Person p = (Person) ctx.getBean("papa");
				
		p.awake();
		p.work();
		p.sleep();
		
		Person b = (Person) ctx.getBean("baby");
				
		b.awake();
		b.work();
		b.sleep();
		
	}

}
