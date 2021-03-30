package com.java.di01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		Su su = new Su();
		su.disp();
		*/
		
		/*
			클래스간의 결합도가 강해지고 의존성이 높아지면 코드를 수정해야 하는 범위가 넓어진다
			클래스간의 결합도를 약하게 의존성을 낮게 작성하기위해 DI라는 설꼐패턴을 사용하는데
			DI는 의존 객체를 외부로부터 전달받아서 구현
		 */
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("appCTX.xml");
		
		Su su = (Su) ctx.getBean("su"); //getBean으로 가져오 때는 강제 형변환 필요
		su.disp();
		ctx.close(); //xml의 사용이 끝나만 닫아줘야함, 메모리를 계속 차지함
	}
}
