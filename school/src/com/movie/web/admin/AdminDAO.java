package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public interface AdminDAO {
	public List<GradeMemberBean>selectGrade();
	public int insert(GradeBean grade);
	public AdminBean selectAdmin(AdminBean admin);
}
