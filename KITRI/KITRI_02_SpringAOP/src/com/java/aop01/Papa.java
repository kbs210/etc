package com.java.aop01;

public class Papa implements Person{

	@Override
	public void awake() {
		System.out.println("�����ܴ�");
	}

	@Override
	public void work() {
		System.out.println("�ý�ź��");
	}

	@Override
	public void sleep() {
		System.out.println("�߱��Ѵ�");
	}

}
