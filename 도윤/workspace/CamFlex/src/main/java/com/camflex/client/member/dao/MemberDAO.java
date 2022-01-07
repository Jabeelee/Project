package com.camflex.client.member.dao;

import java.util.List;

import com.camflex.client.member.vo.MemberVO;
import com.camflex.common.vo.PageRequest;

public interface MemberDAO {

	// 예약 취소 리스트 구현
	public List<MemberVO> cancelList(PageRequest pageRequest) throws Exception;

	// 카운트
	public int count(PageRequest pageRequest) throws Exception;

	// 지난 예약 리스트 구현
	public List<MemberVO> pastList(PageRequest pageRequest) throws Exception;

	// 회원 등록 처리
	public int insertMember(MemberVO mvo)throws Exception;

}