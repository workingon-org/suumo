package com.sinnotech.hotel.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinnotech.hotel.dto.AdminRoomInfoDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.service.RoomInfoService;

/**
 * 관리자 방정보 컨트롤러
 * @author jung
 *
 */
@Controller
@RequestMapping("admin/room/")
public class AdminRoomInfoController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(AdminBookManagementController.class);

	private final static String ADMIN_ROOMINFO_LIST = ADMIN_BASE_PATH + "roomInfo/getRoomInfoList";
	private final static String ADMIN_ROOMINFO_DETAIL = ADMIN_BASE_PATH + "roomInfo/getRoomInfoDetail";
	private final static String ADMIN_ROOMINFO_INSERT = ADMIN_BASE_PATH + "roomInfo/getRoomInfoInsert";
	private final static String ADMIN_ROOMINFO_UPDATE = ADMIN_BASE_PATH + "roomInfo/getRoomInfoUpdate";

	@Autowired
	private RoomInfoService roomInfoService;
	
	/**
	 * 방 목록
	 * @param paging
	 * @return 목록페이지
	 */
	@RequestMapping(value = "roominfolist", method = RequestMethod.GET)
	public ModelAndView getRoomInfoList(Paging paging) {
		
		System.out.println("방정보목록");
		ModelAndView model = new ModelAndView(ADMIN_ROOMINFO_LIST);
		List<AdminRoomInfoDTO> roomInfoList = roomInfoService.getRoomInfoList();
		model.addObject("roomInfoList", roomInfoList);
		
		return model;
	}
	
	/**
	 * 방 상세정보
	 * @param id
	 * @return 상세정보페이지
	 */
	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public ModelAndView getRoomInfoDetail(@PathVariable("id") int id) {
		
		System.out.println("방 상세정보" + id);
		ModelAndView model = new ModelAndView(ADMIN_ROOMINFO_DETAIL);
		AdminRoomInfoDTO roomInfoDetail = roomInfoService.getRoomInfoDetail(id);
		model.addObject("roomInfoDetail", roomInfoDetail);
		
		System.out.println("roomInfoDetail"+roomInfoDetail.toString());
		
		return model;
	}
	
	/**
	 * 방 추가 껍데기
	 * @return 방추가페이지
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public ModelAndView getRoomInfoInsert() {
		
		System.out.println("방 추가(껍데기)");
		ModelAndView model = new ModelAndView(ADMIN_ROOMINFO_INSERT);
		
		return model;
	}
	
	/**
	 * 방 실제 추가페이지
	 * @param adminRoomInfoDTO
	 * @return 리다이렉트: 방 정보 목록 페이지
	 */
	@RequestMapping(value = "realinsert", method = RequestMethod.POST)
	public ModelAndView getRoomInfoRealInsert(AdminRoomInfoDTO adminRoomInfoDTO) {
		
		System.out.println("방 실제추가");
		if(adminRoomInfoDTO.getUpload_file() != null && !adminRoomInfoDTO.getUpload_file().isEmpty()) {
			try {
				String fileName = adminRoomInfoDTO.getUpload_file().getOriginalFilename();
				adminRoomInfoDTO.getUpload_file().transferTo(new File("\\resources\\images\\" + fileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		roomInfoService.getRoomInfoInsert(adminRoomInfoDTO);
		ModelAndView model = new ModelAndView("redirect:/admin/room/roominfolist");
		model.addObject("roomInfoDetail", adminRoomInfoDTO);
		
		return model;
	}
	
	/**
	 * 방 수정 껍데기
	 * @param id
	 * @return 수정 페이지
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView getRoomInfoUpdate(@PathVariable("id") int id) {
		
		System.out.println("방 수정 껍데기");
		ModelAndView model = new ModelAndView(ADMIN_ROOMINFO_UPDATE);
		
		AdminRoomInfoDTO roomInfoDetail = roomInfoService.getRoomInfoDetail(id);
		model.addObject("roomInfoDetail", roomInfoDetail);
		
		return model;
	}
	
	/**
	 * 방 실제 수정
	 * @param adminRoomInfoDTO
	 * @return 리다이렉트: 해당 방 상세페이지
	 */
	@RequestMapping(value = "update/realupdate", method = RequestMethod.POST)
	public ModelAndView getRoomInfoRealUpdate(AdminRoomInfoDTO adminRoomInfoDTO) {
		System.out.println("방 실제 수정");
		if(adminRoomInfoDTO.getUpload_file() != null && !adminRoomInfoDTO.getUpload_file().isEmpty()) {
			try {
				String fileName = adminRoomInfoDTO.getUpload_file().getOriginalFilename();
				adminRoomInfoDTO.getUpload_file().transferTo(new File("\\resources\\images\\" + fileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		roomInfoService.getRoomInfoUpdate(adminRoomInfoDTO);
		ModelAndView model = new ModelAndView("redirect:/admin/room/detail/" + adminRoomInfoDTO.getId());
		model.addObject("roomInfoDetail", adminRoomInfoDTO);
		
		
		return model;
	}
	
	/**
	 * 방 삭제
	 * @param id
	 * @return 방 목록 페이지
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public ModelAndView getRoomInfoDelete(@PathVariable("id") int id) {
		
		System.out.println("방 삭제");
		ModelAndView model = new ModelAndView("redirect:/admin/room/roominfolist");
		roomInfoService.getRoomInfoDelete(id);
		return model;
	}
	
}