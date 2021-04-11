package com.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.database.DBInfo;

public class MemberDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static MemberDao instance = new MemberDao();
	
	public MemberDao() {
		try {
			conn = DBInfo.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insert(MemberDto memberDto) {
		System.out.println("MemberDao insert Run");
		String sql =
				"insert into member values(member_num_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";
		conn = DBInfo.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			pstmt.setString(3, memberDto.getName());
			pstmt.setString(4, memberDto.getJumin1());
			pstmt.setString(5, memberDto.getJumin2());
			pstmt.setString(6, memberDto.getEmail());
			pstmt.setString(7, memberDto.getZipcode());
			pstmt.setString(8, memberDto.getAddress());
			pstmt.setString(9, memberDto.getJob());
			pstmt.setString(10, memberDto.getMailing());
			pstmt.setString(11, memberDto.getInterest());
			pstmt.setString(12, memberDto.getMemberLevel());
			System.out.println(memberDto.getId());
			System.out.println(memberDto.getInterest());
			rs = pstmt.executeQuery();
			System.out.println("rs = pstmt.executeQuery() : " + rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public static MemberDao getInstance() {
		return instance;
	}
	
}
