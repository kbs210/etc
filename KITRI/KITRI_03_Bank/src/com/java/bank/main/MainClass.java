package com.java.bank.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.java.bank.ui.BankUi;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("config.xml");
		BankUi bankUi = (BankUi) ctx.getBean("bankView");
		//bean °´Ã¼µé »ý¼º
		bankUi.execute();
		ctx.close();
	}
}
