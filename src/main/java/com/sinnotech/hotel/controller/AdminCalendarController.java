package com.sinnotech.hotel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.dto.RoomDTO;
import com.sinnotech.hotel.service.BookService;
import com.sinnotech.hotel.service.RoomService;
import com.sinnotech.hotel.util.PathCollection;
import com.sinnotech.hotel.util.Util;

/**
 * 관리자 캘린더 컨트롤러
 * @author KimJeMin
 *
 */
@Controller
public class AdminCalendarController extends BaseController implements PathCollection {
	private final String CALENDAR_BASE = ADMIN_BASE_PATH + BOOK$ + "adminCalendar";

	private String previousContent;

	@Autowired
	private BookService bookService;

	@Autowired
	private RoomService roomService;

	/**
	 * 캘런더 페이지 이동
	 * @param model
	 * @param page 페이징 정보
	 * @return 캘런더 기본 페이지 이동
	 */
	@RequestMapping("admin")
	public String calendar(Model model, Paging page) {
		model.addAttribute("bookingDates", bookService.searchAvaliableBookDate());
		return CALENDAR_BASE;
	}

	/**
	 * 캘런더 정보 검색
	 * @param model
	 * @param roomID 방 ID
	 * @param page 페이징 정보
	 * @param rq
	 * @return 캘런더 정보 검색 페이지
	 */
	@RequestMapping("{roomID}")
	public String calendar(Model model, @PathVariable("roomID") Integer roomID, Paging page, HttpServletRequest rq) {
		System.out.println(page.getDeleteFlag());
		roomSearch(page, model);
		if (roomID != null) {
			model.addAttribute("roomInfo", roomService.searchRoomInfoDetailByRoomID(roomID));
			model.addAttribute("bookingDates", bookService.searchBookDateByRoomID(roomID));
		}
		
		Util.setGET_RETURN_KIND(rq, $ADMIN$CALENDAR$ + roomID, page, HISTORY_BACK);
		return CALENDAR_BASE;
	}

	/**
	 * 캘린더 검색
	 * @param bookInfo 방정보
	 * @param model
	 * @param page 페이징 정보
	 * @param rq
	 * @return 예약 정보
	 */
	@RequestMapping(value = "calendarSelect", method = RequestMethod.GET)
	@ResponseBody
	public BookingsDTO calendarSelect(BookingsDTO bookInfo, Model model,Paging page, HttpServletRequest rq) {
		bookInfo = bookService.searchBookInfoByBookID(bookInfo.getId());
		Util.setGET_RETURN_KIND(rq, "historyback", null, "history.back");
		return bookInfo;
	}
	

	/**
	 * 방 검색
	 * @param page 페이징 정보
	 * @param model
	 * @return 방정보
	 */
	private RoomDTO roomSearch(Paging page, Model model) {
		RoomDTO roomInput;
		if (page == null || page.getCurrentPage() == null) {
			roomInput = roomService.getAllRoomInfoList(page);
		} else {
			if (previousContent != null && !previousContent.equals(page.getContent())) {
				page.setCurrentPage(null);
				page.setStartPage(null);
			}
			previousContent = page.getContent();
			roomInput = roomService.searchedRoomInfoList(page);
		}
		
		model.addAttribute(PAGING, roomInput.getPaging());
		model.addAttribute(ROOMINFOLIST, roomInput.getRoomInfoList());
		return roomInput;
	}

}
