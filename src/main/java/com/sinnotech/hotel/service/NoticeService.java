package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dto.NoticeDTO;
import com.sinnotech.hotel.dto.Paging;

public interface NoticeService {

	/*
	 *Parameter 공지사항DTO
	 */
	void write(NoticeDTO notice);

	/*
	 *Parameter 공지사항DTO, 선택된게시글ID
	 */
	void updateNotice(NoticeDTO notice, Integer noticeId);

	/*
	 *Parameter 공지사항DTO
	 */
	void updateListDelete(NoticeDTO notice);

	List<NoticeDTO> getNoticeList();

	/*
	 *Parameter 선택된게시글ID
	 */
	NoticeDTO getNotice(Integer noticeId);

	/*
	 *Parameter 페이징
	 */
	List<NoticeDTO> getPagingNoticeList(Paging paging);

	int getPagingNoticeListCount();
	
	/*
	 *Parameter 선택된게시글ID
	 */
	void deleteNotice(Integer noticeId);

}
