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
	 * 게시글등록
	 * Parameter 공지사항DTO
	 */
	public void write(NoticeDTO notice) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		mapper.write(notice);
	}
	
	/*
	 * 게시글취득(list)
	 * Parameter 선택된게시글ID
	 */
	public List<NoticeDTO> getNoticeList() {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		return mapper.getNoticeList();
	}
	
	/*
	 * 게시글취득
	 * Parameter 선택된게시글ID
	 */
	public NoticeDTO getNotice(Integer noticeId) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		return mapper.getNotice(noticeId);
	}

	/*
	 * 게시글 수정
	 * Parameter 공지사항DTO, 선택된게시글ID
	 */
	public void updateNotice(NoticeDTO notice, Integer noticeId) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		mapper.updateNotice(notice, noticeId);
	}

	/*
	 * 기한지난 게시글 flag변경 처리
	 * Parameter 공지사항DTO
	 */
	public void updateListDelete(NoticeDTO notice) {
			NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
			mapper.updateListDelete(notice);
	}

	/*
	 * 페이징처리
	 * Parameter 페이징
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
	 * 게시글 삭제처리
	 * Parameter 선택된게시글ID
	 */
	public void deleteNotice(Integer noticeId) {
		NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
		System.out.println(0);
		mapper.deleteNotice(noticeId);
		System.out.println(1);
	}
}
