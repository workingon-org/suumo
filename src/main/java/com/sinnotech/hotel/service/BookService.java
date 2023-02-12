package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.Paging;

/**
 * 관리자 예약 서비스
 * @author KimJeMin
 *
 */
public interface BookService {

	/**
	 * 예약정보 취득
	 * @param page 페이징 정보
	 * @return
	 */
	BookInfo searchAllBookList(Paging page);

	/**
	 * 예약 검색
	 * @param page 페이징 정보
	 * @return
	 */
	BookInfo searchBookList(Paging page);

	/**
	 * 방번호로 예약 정보 검색
	 * @param bookID 예약 ID
	 * @return
	 */
	BookingsDTO searchBookInfoByBookID(Integer bookID);

	/**
	 * 예약정보 수정
	 * @param bookingsDTO
	 * @return
	 */
	BookingsDTO updateBookInfo(BookingsDTO bookingsDTO);

	/**
	 * 예약 취소
	 * @param bookID 예약 ID
	 * @return
	 */
	boolean cancelBookInfoByBookID(Integer bookID);

	/**
	 * 방번호로 모든 예약날짜 취득
	 * @param roomID 방 ID
	 * @return
	 */
	List<BookingsDTO> searchBookDateByRoomID(Integer roomID);

	/**
	 * 방번호로 예약 가능한 날짜 취득
	 * @param roomID 방 ID
	 * @return
	 */
	List<BookingsDTO> searchAvaliableBookDateByRoomID(Integer roomID);

	/**
	 * 예약 가능한 날짜 취득
	 * @return
	 */
	List<BookingsDTO> searchAvaliableBookDate();

}
