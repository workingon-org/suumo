package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dto.NoticeDTO;
import com.sinnotech.hotel.dto.Paging;

public interface NoticeService {

	/*
	 *Parameter ��������DTO
	 */
	void write(NoticeDTO notice);

	/*
	 *Parameter ��������DTO, ���õȰԽñ�ID
	 */
	void updateNotice(NoticeDTO notice, Integer noticeId);

	/*
	 *Parameter ��������DTO
	 */
	void updateListDelete(NoticeDTO notice);

	List<NoticeDTO> getNoticeList();

	/*
	 *Parameter ���õȰԽñ�ID
	 */
	NoticeDTO getNotice(Integer noticeId);

	/*
	 *Parameter ����¡
	 */
	List<NoticeDTO> getPagingNoticeList(Paging paging);

	int getPagingNoticeListCount();
	
	/*
	 *Parameter ���õȰԽñ�ID
	 */
	void deleteNotice(Integer noticeId);

}
