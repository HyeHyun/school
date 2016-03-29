package com.movie.web.grade;

import java.util.*;

public interface GradeDAO {
	// C 성적표 등록
	public int insert(GradeBean grade);
	// R 성적표 리스트 출력
	public List<GradeMemberBean> selectList();
	// R 성적표 조회(이름)
	public List<GradeMemberBean> selectGradesByName(String name);
	// R 성적표 조회(아이디)
	public GradeMemberBean selectGradeById(String id);
	// R 카운트 조회
	public int count();
	// U 성적표 수정
	public String update(GradeBean grade);
	// D 성적표 삭제
	public String delete(int hak);
}
