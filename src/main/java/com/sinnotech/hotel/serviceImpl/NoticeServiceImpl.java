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
	 * �Խñ۵��ó��
	 * Parameter ��������DTO
	 */
	@Override
	public void write(NoticeDTO notice) {
		notice.setEndDate(Util.DateForDB(notice.getEndDate()));
		notice.setStartDate(Util.DateForDB(LocalDate.now().toString()));
		noticeDao.write(notice);
	}

	/*
	 * �Խñ� ����
	 * Parameter ��������DTO, ���õȰԽñ�ID
	 */
	@Override
	public void updateNotice(NoticeDTO notice, Integer noticeId) {
		// EnddayTime����üũ
		if (notice.getEndDate().trim().isEmpty()) {
			notice.setEndDate("9999-12-31");
		}
		notice.setEndDate(Util.DateForDB(notice.getEndDate()));
		notice.setStartDate(Util.DateForDB(LocalDate.now().toString()));
		noticeDao.updateNotice(notice, noticeId);
	}

	/*
	 * �Խñ����
	 * Parameter ���õȰԽñ�ID
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
	 * �������� �Խñ� flag���� ó��
	 * Parameter ��������DTO
	 */
	@Override
	public void updateListDelete(NoticeDTO notice) {
		noticeDao.updateListDelete(notice);
	}

	/*
	 * ����¡ó��
	 * Parameter ����¡
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
	 * �Խñ� ����ó��
	 * Parameter ���õȰԽñ�ID
	 */
	@Override
	public void deleteNotice(Integer noticeId) {
		noticeDao.deleteNotice(noticeId);
	}
}