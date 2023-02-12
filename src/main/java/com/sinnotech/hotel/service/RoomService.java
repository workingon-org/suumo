package com.sinnotech.hotel.service;

import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.dto.RoomDTO;
import com.sinnotech.hotel.dto.RoomInfoDTO;

/**
 * 방 서비스
 * @author KimJeMin
 *
 */
public interface RoomService {

	/**
	 * 방 정보 리스트 취득
	 * @param page 페이징 정보
	 * @return 방 정보 리스트
	 */
	RoomDTO searchedRoomInfoList(Paging page);

	/**
	 * 방 ID로 방 상세정보 검색
	 * @param roomID 방 ID
	 * @return 방 상세정보
	 */
	RoomInfoDTO searchRoomInfoDetailByRoomID(Integer roomID);

	/**
	 * 모든 방정보 취득
	 * @param page 페이징 정보
	 * @return 모든 방정보
	 */
	RoomDTO getAllRoomInfoList(Paging page);
}
