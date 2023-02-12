package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.NoticeDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.mapper.NoticeMapper;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;

	/*
	 * �Խñ۵��
	 * Parameter ��������DTO
	 */
	public void write(NoticeDTO notice) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		mapper.write(notice);
	}
	
	/*
	 * �Խñ����(list)
	 * Parameter ���õȰԽñ�ID
	 */
	public List<NoticeDTO> getNoticeList() {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		return mapper.getNoticeList();
	}
	
	/*
	 * �Խñ����
	 * Parameter ���õȰԽñ�ID
	 */
	public NoticeDTO getNotice(Integer noticeId) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		return mapper.getNotice(noticeId);
	}

	/*
	 * �Խñ� ����
	 * Parameter ��������DTO, ���õȰԽñ�ID
	 */
	public void updateNotice(NoticeDTO notice, Integer noticeId) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		mapper.updateNotice(notice, noticeId);
	}

	/*
	 * �������� �Խñ� flag���� ó��
	 * Parameter ��������DTO
	 */
	public void updateListDelete(NoticeDTO notice) {
			NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
			mapper.updateListDelete(notice);
	}

	/*
	 * ����¡ó��
	 * Parameter ����¡
	 */
	public List<NoticeDTO> getPagingNoticeList(Paging paging) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		return mapper.getPagingNoticeList(paging);
	}

	
	public int getPagingNoticeListCount() {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		return mapper.getPagingNoticeListCount();
	}

	/*
	 * �Խñ� ����ó��
	 * Parameter ���õȰԽñ�ID
	 */
	public void deleteNotice(Integer noticeId) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		System.out.println(0);
		mapper.deleteNotice(noticeId);
		System.out.println(1);
	}
}
