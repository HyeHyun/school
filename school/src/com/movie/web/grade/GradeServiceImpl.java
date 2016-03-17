package com.movie.web.grade;

import java.util.*;

public class GradeServiceImpl implements GradeService {
	// 멤버 필드
	ArrayList<GradeBean> gradeList;
	
	public GradeServiceImpl() {
		gradeList = new ArrayList<GradeBean>(); // 초기화
	}
	
	// 멤버 메소드 에어리어
	@Override
	public void input(GradeBean grade) {
		// 성적표 등록
		gradeList.add(new GradeBean(1, "김구", 100, 100, 100, 100));
		gradeList.add(new GradeBean(2, "강감찬", 90, 90, 90, 90));
		gradeList.add(new GradeBean(3, "유관순", 80, 80, 80, 80));
		gradeList.add(new GradeBean(4, "김구", 70, 70, 70, 70));

		gradeList.add(grade);
	}

	@Override
	public ArrayList<GradeBean> getList() {
		// 성적표 리스트 출력
		return gradeList;
	}

	@Override
	public GradeBean getGradeByHak(int hak) {
		// 성적표 조회(학번)		
		for (int i = 0; i < gradeList.size(); i++) {
			if (gradeList.get(i).getHak() == hak) {
				return gradeList.get(i);
			}
		}
		
		return null;
	}

	@Override
	public ArrayList<GradeBean> getGradesByName(String name) {
		// 성적표 조회(이름)
		ArrayList<GradeBean> tempList = new ArrayList<GradeBean>();
		
		for (int i = 0; i < gradeList.size(); i++) {
			if (gradeList.get(i).getName().equals(name)) {
				tempList.add(gradeList.get(i));
			}
		}

		return tempList;
	}
	
	@Override
	public String getNameByHak(int hak) {
		// 이름 조회(학번)
		GradeBean grade = getGradeByHak(hak);
		return (grade == null ? null : grade.getName());
	}

	@Override
	public int getCount() {
		// 카운트 조회
		return gradeList.size();
	}

	@Override
	public String update(GradeBean grade) {
		// 성적표 수정
		String temp = "";
		
		if (grade.getName() == null) {
			temp = "존재하지 않는 학번입니다.";
		} else {
			GradeBean searchedGrade = getGradeByHak(grade.getHak());
			searchedGrade.setJava(grade.getJava());
			searchedGrade.setSql(grade.getSql());
			searchedGrade.setJsp(grade.getJsp());
			searchedGrade.setSpring(grade.getSpring());
			
			temp = "수정 성공";
		}
		
/*		delete(grade.getHak());
		input(grade);*/

		return temp;
	}

	@Override
	public String delete(int hak) {
		// 성적표 삭제
		return gradeList.remove(getGradeByHak(hak)) ? "삭제 성공" : "삭제 실패";
	}
}
