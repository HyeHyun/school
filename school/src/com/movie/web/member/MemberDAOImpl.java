package com.movie.web.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;

public class MemberDAOImpl implements MemberDAO {

	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체
	private static MemberDAO instance = new MemberDAOImpl();
	
	public MemberDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	@Override
	public int insert(MemberBean member) {
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO Member(id, password, name, addr, birth) VALUES (?, ?, ?, ?, ?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddr());
			pstmt.setInt(5, member.getBirth());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert() 에러 발생!!");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean temp = new MemberBean();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id ='" + id +"'");

			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
			}
		} catch (Exception e) {
			System.out.println("selectMember() 에러 발생!!");
			e.printStackTrace();
		}

		return temp;
	}

	@Override
	public int update(MemberBean member) {
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement("UPDATE Member SET password = ?, addr = ? WHERE id = ?");
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getAddr());
			pstmt.setString(3, member.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("update() 에러 발생!!");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(String id) {
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement("DELETE FROM Member WHERE id = ?");
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete() 에러 발생!!");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean isMember(String id, String password) {
		boolean result = false;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id, password FROM Member WHERE id ='" + id +"' and password = '" + password + "'");

			while (rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("isMember() 에러 발생!!");
			e.printStackTrace();
		}

		return result;
	}	
}
