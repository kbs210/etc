package kr.co.kbs.model;

public class StudentBean {
	
	private String stu_no;
	private String stu_name;
	private String stu_dept;
	private int stu_grade;
	private String stu_class;
	private String stu_gender;
	private double stu_height;
	private double stu_weight;
	private String sub_no;
	private int enr_grade;
	private String sub_name;
	
	//외부에서부터 빈(Bean) 객체에 값을 세팅하기 위한 메소드 구현(Setter)
	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}
	//메소드 구현(Getter)
	public String getStu_no() {
		return stu_no;
	}
	
	
	
	public String getSub_no() {
		return sub_no;
	}
	public void setSub_no(String sub_no) {
		this.sub_no = sub_no;
	}
	public int getEnr_grade() {
		return enr_grade;
	}
	public void setEnr_grade(int enr_grade) {
		this.enr_grade = enr_grade;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_name() {
		return stu_name;
	}
	
	
	
	public void setStu_dept(String stu_dept) {
		this.stu_dept = stu_dept;
	}
	public String getStu_dept() {
		return stu_dept;
	}
	
	
	
	public void setStu_grade(int stu_grade) {
		this.stu_grade = stu_grade;
	}
	public int getStu_grade() {
		return stu_grade;
	}
	
	
	
	public String getStu_class() {
		return stu_class;
	}
	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}
	
	
	//자동완성 우클라 -> source -> generate getters and setters
	public String getStu_gender() {
		return stu_gender;
	}
	public void setStu_gender(String stu_gender) {
		this.stu_gender = stu_gender;
	}
	
	
	public double getStu_height() {
		return stu_height;
	}
	public void setStu_height(double stu_height) {
		this.stu_height = stu_height;
	}
	
	
	
	public double getStu_weight() {
		return stu_weight;
	}
	public void setStu_weight(double stu_weight) {
		this.stu_weight = stu_weight;
	}
	
	
}
