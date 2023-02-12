package com.sinnotech.hotel.service;

import java.util.List;

import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.CommentDTO;
import com.sinnotech.hotel.dto.Paging;

/**
 * 게시판 Service
 * @author JongIn Yoon
 *
 */
public interface BoardService {

	List<BoardDTO> getBoardList(Paging page);

	List<BoardDTO> searchBoardList(Paging page);
		
	BoardDTO boardDetail(Integer id);

	void insertBoard(BoardDTO boardDTO);

	void updateBoard(BoardDTO boardDTO);

	void deleteBoard(Integer id);

	List<CommentDTO> selectCommentList(Integer id);

	boolean insertComment(CommentDTO comment);

	boolean updateComment(CommentDTO comment);

	boolean commentDelete(CommentDTO comment);
}