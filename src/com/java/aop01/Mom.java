package com.java.aop01;

public class Mom implements Person{

	@Override
	public void awake() {
		System.out.println("일어난다");
	}

	@Override
	public void work() {
		System.out.println("출근한다");
	}

	@Override
	public void sleep() {
		System.out.println("잠을잔다");
	}

}
