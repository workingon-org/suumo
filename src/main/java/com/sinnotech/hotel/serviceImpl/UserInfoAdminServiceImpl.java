package com.sinnotech.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.UserDAO;
import com.sinnotech.hotel.dao.UserPageDTO;
import com.sinnotech.hotel.dto.SetPaging;
import com.sinnotech.hotel.dto.UsersDTO;
import com.sinnotech.hotel.helper.SetPagingHelper;
import com.sinnotech.hotel.service.UserInfoAdminService;

/**
 * 유저관리 serviceImpl
 * 
 * @author sunjungkim
 */
@Service
public class UserInfoAdminServiceImpl implements UserInfoAdminService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SetPagingHelper setPagingHelper;

	/**
	 * 전체유저리스트
	 */
	@Override
	public List<UsersDTO> getUsersInfoAllList() {

		List<UsersDTO> userInfo = userDAO.getUsersInfoAllList();
		return userInfo;
	}

	/**
	 * 유저삭제
	 * 
	 * @param id
	 */
	@Override
	public boolean deleteUser(Integer id) {

		return userDAO.deleteUser(id);
	}

	/**
	 * 유저정보 검색
	 * 
	 * @param page
	 */
	@Override
	public UserPageDTO getUsersInfoList(SetPaging page) {
		UserPageDTO userPageDTO = new UserPageDTO();
		page.setTotal(userDAO.getUsersInfoListCount(page));
		page = setPagingHelper.userPaging(page);
		List<UsersDTO> searchUserInfo = userDAO.getUsersInfoList(page);

		userPageDTO.setPaging(page);
		userPageDTO.setUsersDTOList(searchUserInfo);

		return userPageDTO;
	}

	/**
	 * 유저정보리스트 수
	 */
	@Override
	public int getUsersInfoAllListCount() {
		return userDAO.getUsersInfoAllListCount();
	}

	/**
	 * 패스워드갱신
	 * 
	 * @param newPassword
	 * @param id
	 */
	@Override
	public boolean updateUserPassword(String newPassword, Integer id) {
		userDAO.updateUserPassword(newPassword, id);
		return newPassword.equals(userDAO.getUserInfoById(id).getPassword());
	}

}
