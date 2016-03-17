package com.movie.web.member;

public interface MemberDAO {
	public void insert(MemberBean member);
	public String selectById(String id);
	public MemberBean selectMember(String id);
	public void update(MemberBean member);
	public void delete(String id);
}
