package com.movie.web.grade;

import java.util.*;

public class GradeServiceImpl implements GradeService {
	// 멤버 필드
	ArrayList<GradeBean> gradeList;
	GradeDAO dao = new GradeDAOImpl();
	
	public GradeServiceImpl() {
		gradeList = new ArrayList<GradeBean>(); // 초기화
	}
	
	// 멤버 메소드 에어리어
	@Override
	public String input(GradeBean grade) {
		// 성적표 등록
		return dao.insert(grade);
	}

	@Override
	public List<GradeMemberBean> getList() {
		// 성적표 리스트 출력
		return dao.selectAll();
	}

	@Override
	public GradeMemberBean getGradeByHak(int hak) {
		// 성적표 조회(학번)		
		return dao.selectGradeByHak(hak);
	}

	@Override
	public List<GradeMemberBean> getGradesByName(String name) {
		// 성적표 조회(이름)
		return dao.selectGradesByName(name);
	}
	
	@Override
	public GradeMemberBean getGradeById(String id) {
		// 성적표 조회(학번)		
		return dao.selectGradeById(id);
	}

	@Override
	public int getCount() {
		// 카운트 조회
		return dao.count();
	}

	@Override
	public String update(GradeBean grade) {
		// 성적표 수정
		String temp = "";


		return temp;
	}

	@Override
	public String delete(int hak) {
		// 성적표 삭제
		return dao.delete(hak);
	}
}
