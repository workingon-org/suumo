package com.sinnotech.hotel.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinnotech.hotel.dto.NoticeDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.helper.PagingHelper;
import com.sinnotech.hotel.service.NoticeService;
import com.sinnotech.hotel.util.Util;

@Controller
@RequestMapping("admin/notice/")

public class NoticeController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	private final static String INDEX_LIST = ADMIN_BASE_PATH + "notice/list";
	private final static String INDEX_WRITE = ADMIN_BASE_PATH + "notice/write";
	private final static String INDEX_DETAIL = ADMIN_BASE_PATH + "notice/detail";
	private final static String INDEX_UPDATE = ADMIN_BASE_PATH + "notice/update";

	@Autowired
	private NoticeService noticeService;

	/*
	 * 게시물 List 취득
	 * 기간 지난 데이터 delete_flag 변경처리
	 */
	@RequestMapping(value = "list")
	public String noticeList(Model model, Paging paging) {
		logger.info("게시판 리스트 페이지 이동");
		logger.info("기간지난게시물 삭제");
		List<NoticeDTO> noticeList = noticeService.getNoticeList();
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
		PagingHelper pagingHelper = new PagingHelper();

		for (NoticeDTO noticedto : noticeList) {
			if (noticedto.getEndDate().compareTo(today) < 0) {
				noticeService.updateListDelete(noticedto);
			} else {
			}
		}

		if (paging == null || paging.getCurrentPage() == null) {
			paging.setCurrentPage(0);
		}
		noticeList = noticeService.getPagingNoticeList(paging);
		int size = noticeService.getPagingNoticeListCount();
		paging.setTotalCount(size);
		pagingHelper.fliterPaing(paging);
		model.addAttribute("paging", paging);
		model.addAttribute("noticeList", noticeList);
		return INDEX_LIST;
	}
	
	/*
	 * 게시물 등록
	 */
	@RequestMapping(value = "write")
	public String noticewrite(Model model) {
		logger.info("게시판 글쓰기 페이지 이동");
		// 현재날짜 취득
		model.addAttribute("currentTime", LocalDate.now());
		return INDEX_WRITE;
	}
	
	/*
	 * 게시물 저장후 리스트 페이지로 이동
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String noticeSave(NoticeDTO notice) {
		logger.info("게시물 입력후 게시판 리스트 페이지 이동");
		// EnddayTime공백체크
		if (notice.getEndDate().trim().isEmpty()) {
			notice.setEndDate("9999-12-31");
			noticeService.write(notice);
		} else {
			noticeService.write(notice);
		}
		return "redirect:/admin/notice/list";
	}
	
	/*
	 * 게시물 상제페이지이동
	 */
	@RequestMapping(value = "detail/{noticeId}", method = RequestMethod.GET)
	public String noticeDetail(Model model, @PathVariable("noticeId") Integer noticeId) {
		logger.info("게시물 상세 페이지 이동");
		NoticeDTO detail = noticeService.getNotice(noticeId);
		detail.setEndDate(Util.DateForView(detail.getEndDate()));
		model.addAttribute("notice", detail);
		return INDEX_DETAIL;
	}

	/*
	 * 게시물 수정
	 */
	@RequestMapping(value = "update/{noticeId}", method = RequestMethod.GET)
	public String noticeUpdate(Model model, @PathVariable("noticeId") Integer noticeId) {
		logger.info("게시물 수정 페이지 이동");

		NoticeDTO detail = noticeService.getNotice(noticeId);
		model.addAttribute("notice", detail);
		return INDEX_UPDATE;
	}

	/*
	 * 게시물 수정후 리스트 페이지 이동
	 */
	@RequestMapping(value = "updatesave/{noticeId}", method = RequestMethod.POST)
	public String noticeDoUpdate(@PathVariable("noticeId") Integer noticeId, NoticeDTO notice) {

		logger.info("게시물 수정작업 리스트로 이동");
		System.out.println("enddate32 = " + notice.getEndDate());
		noticeService.updateNotice(notice, noticeId);
		return "redirect:/admin/notice/list";
	}

	/*
	 * 게시물 삭제처리 후 리스트 페이지 이동
	 */
	@RequestMapping(value = "/delete/{noticeId}")
	public String delete(Model model, @PathVariable("noticeId") Integer noticeId) {
		logger.info("게시글 삭제");
		noticeService.deleteNotice(noticeId);
		return "redirect:/admin/notice/list";
	}

}
