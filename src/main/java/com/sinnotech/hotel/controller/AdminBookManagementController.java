package com.sinnotech.hotel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.OptionListInfo;
import com.sinnotech.hotel.dto.OptionsDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.helper.OptionHelper;
import com.sinnotech.hotel.service.BookService;
import com.sinnotech.hotel.service.OptionsService;
import com.sinnotech.hotel.util.Constants;
import com.sinnotech.hotel.util.Message;
import com.sinnotech.hotel.util.PathCollection;
import com.sinnotech.hotel.util.Util;

/**
 * 관리자 예약 관리 컨트롤러
 * 
 * @author KimJeMin
 *
 */
@Controller
@RequestMapping("admin/book/")
public class AdminBookManagementController extends BaseController implements PathCollection {

	private static final Logger logger = LoggerFactory.getLogger(AdminBookManagementController.class);

	private final static String ADMIN_BOOKDLIST_INDEX = ADMIN_BASE_PATH + BOOK$ + "adminBookList";
	private final static String ADMIN_BOOKDETAIL_INDEX = ADMIN_BASE_PATH + BOOK$ + "adminBookDetail";

	private String previousContent;

	@Autowired
	private BookService bookService;
	@Autowired
	private OptionsService optionsService;

	/**
	 * 관리자 예약 검색 페이지
	 * 
	 * @param page    페이징DTO
	 * @param options 옵션DTO
	 * @param model
	 * @param rq
	 * @return (관리자용) 예약 검색 페이지 이동
	 */
	@RequestMapping(value = "list")
	public String search(Paging page, OptionsDTO options, Model model, HttpServletRequest rq) {

		// test 5
		logger.info("search() - START");
		BookInfo bookInput;
		// 페이징 처리
		if (page == null || page.getCurrentPage() == null) {
			bookInput = bookService.searchAllBookList(page);
		} else {
			if (previousContent != null && !previousContent.equals(page.getContent())) {
				page.setCurrentPage(null);
				page.setStartPage(null);
			}
			previousContent = page.getContent();
			bookInput = bookService.searchBookList(page);
		}
		model.addAttribute(SELECTEDOPTION, options.getBookingCode());
		model.addAttribute(OPTIONS, bookInput.getOptions());
		model.addAttribute(PAGING, bookInput.getPaging());
		model.addAttribute(BOOKLIST, bookInput.getBookDTOList());
		Util.setGET_RETURN_KIND(rq, $ADMIN$BOOK$LIST, page, REPLACE);
		logger.info("search() - END");
		return ADMIN_BOOKDLIST_INDEX;
	}

	/**
	 * 관리자 예약 상세페이지 이동
	 * 
	 * @param model
	 * @param roomID
	 * @return (관리자용) 예약 상세 페이지 이동
	 */
	@RequestMapping(value = "detail/{room}", method = RequestMethod.GET)
	public String detail(Model model, @PathVariable("room") Integer roomID) {
		logger.info("detail() - START");
		BookingsDTO bookings = bookService.searchBookInfoByBookID(roomID);
		model.addAttribute(READONLY, Constants.READONLY);
		model.addAttribute(DISABLED, Constants.DISABLED);
		model.addAttribute(BOOK, bookings);
		model.addAttribute(SELECTEDOPTION, optionsService.getBookingOptionNameByRoomID(bookings.getOptions()));
		logger.info("detail() - END");
		return ADMIN_BOOKDETAIL_INDEX;
	}

	/**
	 * 예약정보 수정 페이지 이동
	 * 
	 * @param id          예약번호
	 * @param bookingsDTO 예약 DTO
	 * @param model
	 * @return (관리자용) 예약 수정 페이지 이동
	 */
	@RequestMapping(value = "update/{bookID}", method = RequestMethod.GET)
	public String getUpdate(@PathVariable("bookID") Integer id, BookingsDTO bookingsDTO, Model model) {
		logger.info("getUpdate() - START");
		BookingsDTO bookings = bookService.searchBookInfoByBookID(id);
		List<OptionsDTO> options = optionsService.getBookingOptions();
		List<OptionsDTO> selectedOptions = optionsService.getBookingOptionNameByRoomID(bookings.getOptions());
		model.addAttribute(FORM, Constants.UPDATE_FORM);
		model.addAttribute(BOOK, bookings);
		model.addAttribute(OPTIONS, options);
		BookInfo bookInfo = (new OptionHelper()).selectedOptionHelper(options, selectedOptions);
		if (bookInfo != null) {
			int i = 0;
			for (OptionListInfo option : bookInfo.getOptionInfo()) {
				model.addAttribute(OPTIONS + i++, option.getOptionListInfo());

			}
		}
		logger.info("getUpdate() - END");
		return ADMIN_BOOKDETAIL_INDEX;
	}

	/**
	 * 예약정보 수정하기
	 * 
	 * @param id          예약번호
	 * @param bookingsDTO 예약 DTO
	 * @param model
	 * @return (관리자용) 예약 상세 페이지 이동
	 */
	@RequestMapping(value = "update/{bookID}", method = RequestMethod.POST)
	public String postUpdate(@PathVariable("bookID") Integer id, BookingsDTO bookingsDTO, Model model) {
		logger.info("postUpdate() - START");
		bookingsDTO = bookService.updateBookInfo(bookingsDTO);
		model.addAttribute(DISABLED, Constants.DISABLED);
		model.addAttribute(READONLY, Constants.READONLY);
		model.addAttribute(BOOK, bookingsDTO);
		model.addAttribute(SELECTEDOPTION, optionsService.getBookingOptionNameByRoomID(bookingsDTO.getOptions()));
		logger.info("postUpdate() - END");
		return ADMIN_BOOKDETAIL_INDEX;
	}

	/**
	 * 예약 취소
	 * 
	 * @param model
	 * @param bookID 예약번호
	 * @param rq
	 * @return (관리자용) 예약 검색 페이지 이동
	 */
	@RequestMapping(value = "delete/{bookID}", method = RequestMethod.GET)
	public String cancel(Model model, @PathVariable("bookID") Integer bookID, RedirectAttributes rq) {
		logger.info("cancel() - START");
		boolean result = bookService.cancelBookInfoByBookID(bookID);
		rq.addFlashAttribute(MESSAGE, result == true ? Message.CANCEL_SUCCEED : Message.CANCEL_SUCCEED);
		logger.info("cancel() - END");
		return result == true ? REDRIRECT + $ + ADMIN_BASE_PATH + BOOK$ + DETAIL + $ + bookID
				: REDRIRECT + Util.GET_RETURN_KIND + bookID;
	}
}