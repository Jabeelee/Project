package com.camflex.admin.member.dao;

import java.util.List;

import com.camflex.client.login.vo.LoginVO;

public interface AdminMemberDAO {

	// 회원 리스트
	public List<LoginVO> memberList(LoginVO lvo);
	// 전체 레코드 수 구현
	public int memberListCnt(LoginVO lvo);

}
