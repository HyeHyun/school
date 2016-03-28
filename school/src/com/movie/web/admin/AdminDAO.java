package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

public interface AdminDAO {
	public List<MemberBean>selectMember();
	public List<GradeMemberBean>selectGrade();
	public int insert(GradeBean grade);
	public AdminBean selectAdmin(AdminBean admin);
}
