package com.java.aop01;

public class Baby implements Person{

	@Override
	public void awake() {
		System.out.println("����ܴ�");
	}

	@Override
	public void work() {
		System.out.println("�׸��׸�");
	}

	@Override
	public void sleep() {
		System.out.println("�����ܴ�");
	}

}
