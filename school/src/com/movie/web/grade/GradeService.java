package com.movie.web.grade;

import java.util.*;

/**
 * CRUD
 * C : create 생성
 * R : read 조회
 * U : update 수정
 * D : delete 삭제
 * 
 * */
public interface GradeService {
	// C 성적표 등록
	public int input(GradeBean grade);
	// R 성적표 리스트 출력
	public List<GradeMemberBean> getList();
	// R 성적표 조회(이름)
	public List<GradeMemberBean> getGradesByName(String name);
	// R 성적표 조회(아이디)
	public GradeMemberBean getGradeById(String id);
	// R 카운트 조회
	public int getCount();
	// U 성적표 수정
	public String update(GradeBean grade);
	// D 성적표 삭제
	public String delete(int hak);
}
