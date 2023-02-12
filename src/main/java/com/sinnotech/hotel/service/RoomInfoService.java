package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dto.AdminRoomInfoDTO;

/**
 * 관리자 방정보 서비스
 * @author jung
 *
 */
public interface RoomInfoService {
	
	/**
	 * 방정보 리스트
	 */
	List<AdminRoomInfoDTO>  getRoomInfoList();
	
	/**
	 * 방정보 상세
	 * @param id
	 */
	AdminRoomInfoDTO  getRoomInfoDetail(int id);
	
	/**
	 * 방정보 추가
	 * @param adminRoomInfoDTO
	 */
	int getRoomInfoInsert(AdminRoomInfoDTO adminRoomInfoDTO);
	
	/**
	 * 방정보 수정
	 * @param adminRoomInfoDTO
	 */
	int getRoomInfoUpdate(AdminRoomInfoDTO adminRoomInfoDTO);
	
	/**
	 * 방정보 삭제
	 * @param adminRoomInfoDTO
	 */
	int getRoomInfoDelete(int adminRoomInfoDTO);
	

}
