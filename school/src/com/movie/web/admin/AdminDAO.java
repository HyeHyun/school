package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public interface AdminDAO {
	public List<GradeMemberBean>select();
	public int insert(GradeBean grade);
}
