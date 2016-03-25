package com.movie.web.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

public class AdminDAOImpl implements AdminDAO {
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체
	private static AdminDAO instance = new AdminDAOImpl();
	
	public AdminDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}
	
	public static AdminDAO getInstance() {
		return instance;
	}

	@Override
	public List<MemberBean> selectMember() {
		List<MemberBean> list = new Vector<MemberBean>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member");

			while (rs.next()) {
				MemberBean member = new MemberBean();
				
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
				member.setBirth(rs.getInt("birth"));
				
				list.add(member);
			}
		} catch (Exception e) {
			System.out.println("selectMember() 에러 발생!!");
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public List<GradeMemberBean> selectGrade() {
		List<GradeMemberBean> list = new Vector<GradeMemberBean>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");

			while (rs.next()) {
				GradeMemberBean bean = new GradeMemberBean();
				
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSql(rs.getInt("sql"));
				bean.setSpring(rs.getInt("spring"));
				
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectGrade() 에러 발생!!");
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int insert(GradeBean grade) {
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO Grade(score_seq, id, java, sql, jsp, spring) VALUES (score_seq.NEXTVAL, ?, ?, ?, ?, ?)");
			pstmt.setString(1, grade.getId());
			pstmt.setInt(2, grade.getJava());
			pstmt.setInt(3, grade.getSql());
			pstmt.setInt(4, grade.getJsp());
			pstmt.setInt(5, grade.getSpring());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert() 에러 발생!!");
			e.printStackTrace();
		}
		
		return result;
	}
}
