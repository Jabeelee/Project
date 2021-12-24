package com.camflex.admin.reservation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.PageRequest;

@Repository
public class AdminReservationDAOImpl implements AdminReservationDAO {

	@Autowired
	private SqlSession sqlSession;

	// 예약 리스트
	@Override
	public List<ReservationVO> reservationList(PageRequest pageRequest) {
		
		return sqlSession.selectList("reservationList");
	}

	// 예약 전체 수를 반환
	@Override
	public int count(PageRequest pageRequest) {
		
		return sqlSession.selectOne("count");
	}

	// 신규 예약 리스트
	@Override
	public List<ReservationVO> newRsvList(ReservationVO rvo) {
		
		return sqlSession.selectList("newRsvList", rvo);
	}

	@Override
	public int confirmRsv(int r_number) {
		
		return sqlSession.update("confirm", r_number);
	}

	



}
