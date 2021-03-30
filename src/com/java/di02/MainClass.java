package com.java.di02;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.java.di01.Su;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("appCTX.xml");

		Example e = (Example) ctx.getBean("example");
		Testing t = (Testing) ctx.getBean("testing");
		
		Su s = (Su) ctx.getBean("su");
		
		e.disp();
		t.disp();
		
		s.disp();
		
		ctx.close();
	}
}
