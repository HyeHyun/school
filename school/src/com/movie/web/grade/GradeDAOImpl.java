package com.movie.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import com.movie.web.global.Constants;

public class GradeDAOImpl implements GradeDAO {
	
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체
	
	@Override
	public String insert(GradeBean grade) {
		String result = "등록실패";
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			pstmt = conn.prepareStatement("INSERT INTO Grade(hak, id, java, sql, jsp, spring) VALUES (hak_seq.NEXTVAL, ?, ?, ?, ?, ?);");
			pstmt.setString(1, grade.getId());
			pstmt.setInt(2, grade.getJava());
			pstmt.setInt(3, grade.getSql());
			pstmt.setInt(4, grade.getJsp());
			pstmt.setInt(5, grade.getSpring());
			pstmt.executeUpdate();
			
			result = "등록성공";
		} catch (Exception e) {
			System.out.println("insert() 에러 발생!!");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<GradeMemberBean> selectAll() {
		List<GradeMemberBean> list = new Vector<GradeMemberBean>();
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");

			while (rs.next()) {
				GradeMemberBean bean = new GradeMemberBean();
				
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSql(rs.getInt("sql"));
				bean.setSpring(rs.getInt("spring")); 
				
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectAll() 에러 발생!!");
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public GradeMemberBean selectGradeByHak(int hak) {
		GradeMemberBean bean = new GradeMemberBean();
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE hak ='" + hak +"'");
			
			while (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSql(rs.getInt("sql"));
				bean.setSpring(rs.getInt("spring"));
			}
		} catch (Exception e) {
			System.out.println("selectGradeByHak() 에러 발생!!");
			e.printStackTrace();
		}

		return bean;
	}

	@Override
	public List<GradeMemberBean> selectGradesByName(String name) {
		List<GradeMemberBean> list = new Vector<GradeMemberBean>();
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE name ='" + name +"'");

			while (rs.next()) {
				GradeMemberBean bean = new GradeMemberBean();
				
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSql(rs.getInt("sql"));
				bean.setSpring(rs.getInt("spring")); 
				
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectGradesByName() 에러 발생!!");
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int count() {
		int count = 0;
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM GradeMember");

			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("count() 에러 발생!!");
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public String update(GradeBean grade) {
		return null;
	}

	@Override
	public String delete(int hak) {
		String result = "삭제 실패";
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			pstmt = conn.prepareStatement("DELETE FROM GradeMember WHERE hak = ?");
			pstmt.setInt(1, hak);
			pstmt.executeUpdate();
			
			result = "삭제 성공";
		} catch (Exception e) {
			System.out.println("delete() 에러 발생!!");
			e.printStackTrace();
		}

		return result;
	}
}
