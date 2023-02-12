package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sinnotech.hotel.dto.AdminRoomInfoDTO;
import com.sinnotech.hotel.dto.Paging;

/**
 * 관리자 방정보 Mapper
 * @author jung
 *
 */
@Mapper
public interface RoomInfoMapper {

	List<AdminRoomInfoDTO> getRoomInfoList();
	AdminRoomInfoDTO getRoomInfoDetail(int id);
	int getRoomInfoInsert(AdminRoomInfoDTO adminRoomInfoDTO);
	int getRoomInfoUpdate(AdminRoomInfoDTO adminRoomInfoDTO);
	int getRoomInfoDelete(int adminRoomInfoDTO);
}
