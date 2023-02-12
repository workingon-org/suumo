package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dao.UserPageDTO;
import com.sinnotech.hotel.dto.SetPaging;
import com.sinnotech.hotel.dto.UsersDTO;

/**
 * 관리자 유저정보 서비스
 * 
 * @author sunjungkim
 */
public interface UserInfoAdminService {
	/**
	 * 전체유저리스트
	 */
	List<UsersDTO> getUsersInfoAllList();

	/**
	 * 유저삭제
	 * 
	 * @param id
	 */
	boolean deleteUser(Integer id);

	/**
	 * 유저정보 검색
	 * 
	 * @param page
	 */
	UserPageDTO getUsersInfoList(SetPaging page);

	/**
	 * 유저정보리스트 수
	 */
	int getUsersInfoAllListCount();

	/**
	 * 패스워드갱신
	 * 
	 * @param newPassword
	 * @param id
	 */
	boolean updateUserPassword(String newPassword, Integer id);

}
