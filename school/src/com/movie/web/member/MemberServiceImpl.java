package com.movie.web.member;

import java.util.HashMap;

public class MemberServiceImpl implements MemberService {

	HashMap<String, MemberBean> map;
	MemberDAO dao = MemberDAOImpl.getInstance();
	private static MemberService instance = new MemberServiceImpl();

	public static MemberService getInstance() {
		return instance;
	}
	
	@Override
	public int join(MemberBean member) {
		// 회원가입
		return dao.insert(member);
	}

	@Override
	public MemberBean detail(String id) {
		return dao.selectById(id);
	}
	
	@Override
	public int update(MemberBean member) {
		// 수정
		return dao.update(member);
	}

	@Override
	public int remove(String id) {
		// 삭제
		return dao.delete(id);
	}

	@Override
	public boolean login(String id, String password) {
		// 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비번이 틀려서 실패한 경우에 따라서 메시지를 전달해줘야 함
		return dao.isMember(id, password);
	}
}
