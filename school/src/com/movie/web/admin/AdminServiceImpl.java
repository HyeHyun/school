package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeMemberBean;

public class AdminServiceImpl implements AdminService {
	AdminDAO dao = AdminDAOImpl.getInstance();
	private static AdminService instance = new AdminServiceImpl();

	public static AdminService getInstance() {
		return instance;
	}
	
	@Override
	public List<GradeMemberBean> getMemberList() {
		return dao.select();
	}

	@Override
	public int addScore(GradeMemberBean bean) {
		return 0;
	}

}
