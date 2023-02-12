package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.AdminRoomInfoDTO;
import com.sinnotech.hotel.mapper.RoomInfoMapper;

/**
 * 관리자 방정보 DAO
 * @author jung
 *
 */
@Repository
public class RoomInfoDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<AdminRoomInfoDTO> getRoomInfoList(){
		RoomInfoMapper mapper = sqlSession.getMapper(RoomInfoMapper.class);
		return mapper.getRoomInfoList();
	}
	
	public AdminRoomInfoDTO getRoomInfoDetail(int id){
		RoomInfoMapper mapper = sqlSession.getMapper(RoomInfoMapper.class);
		return mapper.getRoomInfoDetail(id);
	}
	
	public int getRoomInfoInsert(AdminRoomInfoDTO adminRoomInfoDTO) {
		RoomInfoMapper mapper = sqlSession.getMapper(RoomInfoMapper.class);
		return mapper.getRoomInfoInsert(adminRoomInfoDTO);
	}
	
	public int getRoomInfoUpdate(AdminRoomInfoDTO adminRoomInfoDTO) {
		RoomInfoMapper mapper = sqlSession.getMapper(RoomInfoMapper.class);
		return mapper.getRoomInfoUpdate(adminRoomInfoDTO);
	}
	
	public int getRoomInfoDelete(int adminRoomInfoDTO) {
		RoomInfoMapper mapper = sqlSession.getMapper(RoomInfoMapper.class);
		return mapper.getRoomInfoDelete(adminRoomInfoDTO);
	}

}
