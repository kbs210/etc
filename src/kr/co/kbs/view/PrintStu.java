package kr.co.kbs.view;

import java.util.List;

import kr.co.kbs.model.StudentBean;

public class PrintStu {

	//학생 정보 출력 메소드 생성
	public void printStu(List<StudentBean> stList) {
		
		for(int i=0; i<stList.size(); i++) {
			System.out.print("학번 : " + stList.get(i).getStu_no() + " ");
			System.out.print("이름 : " + stList.get(i).getStu_name() + " ");
			System.out.print("학과 : " + stList.get(i).getStu_dept() + " ");
			System.out.print("학년 : " + stList.get(i).getStu_grade() + " ");
			System.out.print("반 : " + stList.get(i).getStu_class() + " ");
			System.out.print("성별 : " + stList.get(i).getStu_gender() + " ");
			System.out.print("키 : " + stList.get(i).getStu_height() + " ");
			System.out.print("몸무게 : " + stList.get(i).getStu_weight() + " ");
			System.out.println();
			
			/*
			StudentBean sb = stList.get(i);
			System.out.println("학번 : " + sb.getStu_no() + " ");
			System.out.println("이름 : " + sb.getStu_name() + " ");
			System.out.println("학과 : " + sb.getStu_dept() + " ");
			System.out.println("학년 : " + sb.getStu_grade() + " ");
			System.out.println("반 : " + sb.getStu_class() + " ");
			System.out.println("성별 : " + sb.getStu_gender() + " ");
			System.out.println("키 : " + sb.getStu_height() + " ");
			System.out.println("몸무게 : " + sb.getStu_weight() + " ");
			System.out.println();
			*/
			
		} // for문 종료지점
		
	}
	
}
