package com.movie.web.member;

import java.util.HashMap;

public class MemberServiceImpl implements MemberService {

	HashMap<String, MemberBean> map;
	MemberDAO dao = new MemberDAOImpl();
	
	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}
	
	@Override
	public void join(MemberBean member) {
		// 회원가입
		map.put(member.getId(), member);
	}

	@Override
	public MemberBean detail(String id) {
		return dao.selectMember(id);
	}
	
	@Override
	public String update(MemberBean member) {
		// 수정
		String result = "";
		if (member.getId().equals(null)) {
			result = "수정 실패";
		} else {
			map.replace(member.getId(), member);
			result = "수정 성공";
		}
		
		return result;
	}

	@Override
	public String remove(String id) {
		// 삭제
		map.remove(id);
		
		return "삭제 성공";
	}

	@Override
	public boolean login(String id, String password) {
		// 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비번이 틀려서 실패한 경우에 따라서 메시지를 전달해줘야 함
		return dao.isMember(id, password);
	}
}
