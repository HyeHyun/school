package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

public class AdminServiceImpl implements AdminService {
	AdminDAO dao = AdminDAOImpl.getInstance();
	private static AdminService instance = new AdminServiceImpl();

	public static AdminService getInstance() {
		return instance;
	}

	@Override
	public List<GradeMemberBean> getGradeList() {
		return dao.selectGrade();
	}

	@Override
	public int addScore(GradeBean grade) {
		return dao.insert(grade);
	}

	@Override
	public AdminBean getAdmin(AdminBean admin) {
		return dao.selectAdmin(admin);
	}

}
