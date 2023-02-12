package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sinnotech.hotel.dto.NoticeDTO;
import com.sinnotech.hotel.dto.Paging;

@Mapper
public interface NoticeMapper {

	void write(@Param("notice") NoticeDTO notice);

	void updateNotice(@Param("notice") NoticeDTO notice, @Param("id") Integer noticeId);

	void updateListDelete(@Param("notice") NoticeDTO notice);

	List<NoticeDTO> getNoticeList();

	NoticeDTO getNotice(@Param("id") Integer noticeId);

	List<NoticeDTO> getPagingNoticeList(@Param("paging") Paging paging);

	int getPagingNoticeListCount();

	void deleteNotice(@Param("id") Integer noticeId);

}
