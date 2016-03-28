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

	@Override
	public AdminBean selectAdmin(AdminBean admin) {
		AdminBean bean = new AdminBean();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM Admin WHERE id=? and password=?");
			pstmt.setString(1, admin.getId());
			pstmt.setString(2, admin.getPassword());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setPassword(rs.getString("password"));
				bean.setName(rs.getString("name"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			System.out.println("selectAdmin() 에러 발생!!");
			e.printStackTrace();
		}
		return bean;
	}
}
