package kr.co.kbs.cont;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kbs.model.StudentBean;

/**
 * Servlet implementation class StuCont
 */
@WebServlet("/enrol.do")
public class StuCont2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StuCont2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	String stu_no;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a = request.getParameter("stu_no");
		// Maria DB 있으니, Maria DB에 값을 불러오도록 구성하기

		// DB연동 1. JDBC Driver 호출
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2. Driver를 통해 Maria DB 접근 Connection 생성

		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test?user=root&password=1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3. SQL 명령어를 수행할 수 있도록 하기 위한 Statement 생성
		// 4. SQL 명령어 실 후 결과값을 ResultSet 저장

		// 새록게 생성되는 각 사용자별 sb값을 Array List에 저장할 수 있도록 구성하기
		// ArraList<>(), LinkedList<>()
		List<StudentBean> sbList = new ArrayList<StudentBean>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT s.stu_no, stu_name, sub_no, sub_name, enr_grade FROM student s LEFT OUTER JOIN (SELECT * FROM enrol e LEFT OUTER JOIN subject sb USING(sub_no)) a USING(stu_no) WHERE stu_no=" + a );

			// 5. ResultSet에 저장된 값을 Java Bean 객체에 저장하기

			while (rs.next()) {

				// 최종으로 해당 학생들의 정보를 sb에 세팅함
				StudentBean sb = new StudentBean();

				sb.setStu_no(rs.getString("stu_no"));
				sb.setStu_name(rs.getString("stu_name"));
				sb.setSub_no(rs.getString("sub_no"));
				sb.setSub_name(rs.getString("sub_name"));
				sb.setEnr_grade(rs.getInt("enr_grade"));

				/*
				 * 칼럼 번호로도 가능 sb.setStu_no(rs.getString("1"));
				 * sb.setStu_name(rs.getString("2")); sb.setStu_dept(rs.getString("3"));
				 * sb.setStu_grade(rs.getInt("4")); sb.setStu_class(rs.getString("5"));
				 * sb.setStu_gender(rs.getString("6")); sb.setStu_height(rs.getDouble("7"));
				 * sb.setStu_weight(rs.getDouble("8"));
				 */

				// 세팅 된 각각의 sb는 while문이 끝나면 지워짐으로 없어지지 않게 sbList에 저장
				sbList.add(sb);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 6. ResultSet, Statement, Connection 종료
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// test겸 콘솔장에 출력해보기
		// PrintStu ps = new PrintStu();
		// ps.printStu(sbList);

		// sbList -> tables.jsp에 전달하기
		// request.setAttr 값을 저장하여 전달
		request.setAttribute("STU", sbList);
		RequestDispatcher rd = request.getRequestDispatcher("enrol.jsp");
		rd.forward(request, response);

	} // doPost 메소드 종료

} // StuCont Class 종료
