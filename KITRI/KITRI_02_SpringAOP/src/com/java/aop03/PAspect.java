package com.java.aop03;

public class PAspect {

	public void open() {
		System.out.println("수업시작, 강의장에 들어온다");
	}
	
	public void close() {
		System.out.println("수업끝, 강의장을 나간다");
	}
	
	public void error() {
		System.out.println("떠들다가 혼남");
	}
	
	public void eat() {
		System.out.println("점심을 맛있게 먹는다");
	}
	
}
