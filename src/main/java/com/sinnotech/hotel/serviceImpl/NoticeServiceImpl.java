package com.sinnotech.hotel.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.NoticeDAO;
import com.sinnotech.hotel.dto.NoticeDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.service.NoticeService;
import com.sinnotech.hotel.util.Util;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDao;

	/*
	 * 게시글등록처리
	 * Parameter 공지사항DTO
	 */
	@Override
	public void write(NoticeDTO notice) {
		notice.setEndDate(Util.DateForDB(notice.getEndDate()));
		notice.setStartDate(Util.DateForDB(LocalDate.now().toString()));
		noticeDao.write(notice);
	}

	/*
	 * 게시글 수정
	 * Parameter 공지사항DTO, 선택된게시글ID
	 */
	@Override
	public void updateNotice(NoticeDTO notice, Integer noticeId) {
		// EnddayTime공백체크
		if (notice.getEndDate().trim().isEmpty()) {
			notice.setEndDate("9999-12-31");
		}
		notice.setEndDate(Util.DateForDB(notice.getEndDate()));
		notice.setStartDate(Util.DateForDB(LocalDate.now().toString()));
		noticeDao.updateNotice(notice, noticeId);
	}

	/*
	 * 게시글취득
	 * Parameter 선택된게시글ID
	 */
	@Override
	public NoticeDTO getNotice(Integer noticeId) {
		return noticeDao.getNotice(noticeId);
	}

	
	@Override
	public List<NoticeDTO> getNoticeList() {
		return noticeDao.getNoticeList();
	}

	/*
	 * 기한지난 게시글 flag변경 처리
	 * Parameter 공지사항DTO
	 */
	@Override
	public void updateListDelete(NoticeDTO notice) {
		noticeDao.updateListDelete(notice);
	}

	/*
	 * 페이징처리
	 * Parameter 페이징
	 */
	@Override
	public List<NoticeDTO> getPagingNoticeList(Paging paging) {
		return noticeDao.getPagingNoticeList(paging);
	}

	@Override
	public int getPagingNoticeListCount() {
		return noticeDao.getPagingNoticeListCount();
	}

	/*
	 * 게시글 삭제처리
	 * Parameter 선택된게시글ID
	 */
	@Override
	public void deleteNotice(Integer noticeId) {
		noticeDao.deleteNotice(noticeId);
	}
}