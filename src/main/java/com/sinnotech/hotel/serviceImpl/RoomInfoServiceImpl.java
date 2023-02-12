package com.sinnotech.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.RoomInfoDAO;
import com.sinnotech.hotel.dto.AdminRoomInfoDTO;
import com.sinnotech.hotel.service.RoomInfoService;

/**
 * 관리자 방정보 serviceImpl
 * @author jung
 *
 */
@Service
public class RoomInfoServiceImpl implements RoomInfoService{

	@Autowired
	private RoomInfoDAO roomInfoDAO;
	
	/**
	 * 방정보 목록
	 */
	@Override
	public List<AdminRoomInfoDTO> getRoomInfoList() {
		return roomInfoDAO.getRoomInfoList();
	}
	
	/**
	 * 방정보 상세
	 * @param id
	 */
	@Override
	public AdminRoomInfoDTO getRoomInfoDetail(int id) {
		return roomInfoDAO.getRoomInfoDetail(id);
	}

	/**
	 * 방정보 추가
	 * @param adminRoomInfoDTO
	 */
	@Override
	public int getRoomInfoInsert(AdminRoomInfoDTO adminRoomInfoDTO) {
		return roomInfoDAO.getRoomInfoInsert(adminRoomInfoDTO);
	}

	/**
	 * 방정보 수정
	 * @param adminRoomInfoDTO
	 */
	@Override
	public int getRoomInfoUpdate(AdminRoomInfoDTO adminRoomInfoDTO) {
		return roomInfoDAO.getRoomInfoUpdate(adminRoomInfoDTO);
	}
	
	/**
	 * 방정보 삭제
	 * @param adminRoomInfoDTO
	 */
	@Override
	public int getRoomInfoDelete(int adminRoomInfoDTO) {
		return roomInfoDAO.getRoomInfoDelete(adminRoomInfoDTO);
	}
	
}
