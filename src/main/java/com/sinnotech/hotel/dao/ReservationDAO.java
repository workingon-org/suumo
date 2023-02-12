package com.sinnotech.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.ReservationDTO;
import com.sinnotech.hotel.mapper.BoardMapper;
import com.sinnotech.hotel.mapper.ReservationMapper;

@Repository
public class ReservationDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<ReservationDTO> getReservationList() {
		ReservationMapper mapper = sqlSession.getMapper(ReservationMapper.class);
		return mapper.getReservationList();
	}

	public ArrayList<ReservationDTO> selectRoomByPeople(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ReservationDTO> selectRoomByDate(ArrayList<ReservationDTO> room_type, String r_checkin,
			String r_checkout) {
		// TODO Auto-generated method stub
		return null;
	}

	public ReservationDTO checkRoom() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void insertReservation(ReservationDTO reservationDTO) {
		ReservationMapper mapper = sqlSession.getMapper(ReservationMapper.class);
		mapper.insertReservation(reservationDTO);
	}

}
