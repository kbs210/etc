package com.java.aop01;

public class Baby implements Person{

	@Override
	public void awake() {
		System.out.println("계속잔다");
	}

	@Override
	public void work() {
		System.out.println("그림그림");
	}

	@Override
	public void sleep() {
		System.out.println("코코잔다");
	}

}
