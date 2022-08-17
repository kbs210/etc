package com.java.aop04;

public class Teacher implements Person{

	@Override
	public void work() {
		System.out.println("선생님은 강의를 합니다");
	}

}
