package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.dto.RoomInfoDTO;
import com.sinnotech.hotel.mapper.BookMapper;
import com.sinnotech.hotel.util.Util;

/**
 * 관리자 예약 DAO
 * @author KimJeMin
 *
 */
@Repository
public class BookDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<BookingsDTO> getAllBookList(Paging page) {
		return sqlSession.getMapper(BookMapper.class).getAllBookList(page);
	}

	public BookInfo searchBookList(Paging page) {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookDTOList(sqlSession.getMapper(BookMapper.class).searchBookList(page));
		bookInfo.setPaging(page);
		if (!page.getStartDate().isEmpty())
			bookInfo.getPaging().setStartDate(Util.DateForView(page.getStartDate()));
		if (!page.getEndDate().isEmpty())
			bookInfo.getPaging().setEndDate(Util.DateForView(page.getEndDate()));
		return bookInfo;
	}

	public BookingsDTO getBookInfo(Integer BookId) {
		return sqlSession.getMapper(BookMapper.class).getBookInfo(BookId);
	}

	public BookingsDTO updateBookInfo(BookingsDTO bookingsDTO) {
		sqlSession.getMapper(BookMapper.class).updateBookInfo(bookingsDTO);
		BookingsDTO updatedBookings = getBookInfo(bookingsDTO.getId());
		if (bookingsDTO.getUpdatedAt() != updatedBookings.getUpdatedAt())
			return updatedBookings;
		else
			return null;
	}

	public boolean cancelBookInfo(Integer bookID) {
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		mapper.cancelBookInfo(bookID);
		return mapper.checkIfBookingCancelled(bookID) != null ? true : false;
	}

	public Integer getAllBookingCount() {
		return sqlSession.getMapper(BookMapper.class).getAllBookingCount();
	}

	public Integer getSearchedBookingCount(Paging paging) {
		return sqlSession.getMapper(BookMapper.class).getSearchedBookingCount(paging);
	}

	public List<BookingsDTO> searchBookDateByRoomID(Integer roomID) {
		return sqlSession.getMapper(BookMapper.class).searchBookDateByRoomID(roomID);
	}

	public List<BookingsDTO> searchAvaliableBookDateByRoomID(Integer roomID) {
		return sqlSession.getMapper(BookMapper.class).searchAvaliableBookDateByRoomID(roomID);
	}

	public List<BookingsDTO> searchAvaliableBookDate() {
		return sqlSession.getMapper(BookMapper.class).searchAvaliableBookDate();
	}

}
