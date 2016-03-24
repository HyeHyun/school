package com.movie.web.member;

public interface MemberDAO {
	public int insert(MemberBean member);
	public MemberBean selectById(String id);
	public int update(MemberBean member);
	public int delete(String id);
	public boolean isMember(String id, String password);
}
