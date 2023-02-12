package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.CommentDTO;
import com.sinnotech.hotel.dto.Paging;

/**
 * 게시판 Mapper
 * @author JongIn Yoon
 *
 */
@Mapper
public interface BoardMapper {

	public List<BoardDTO> getBoardList(@Param("paging") Paging paging);
	
	public List<BoardDTO> searchBoardList(@Param("paging") Paging paging);

	public BoardDTO boardDetail(@Param("id") Integer id);
	
	public void insertBoard(BoardDTO boardDTO);

	public void updateBoard(BoardDTO boardDTO);

	public void deleteBoard(@Param("id") Integer id);

	public Integer getAllBoardCount(@Param("paging") Paging page);

	public Integer searchBoardListCount(@Param("paging")Paging page);

	public void insertComment(CommentDTO comment);

	public List<CommentDTO> selectCommentList(int boardId);

	public void updateComment(CommentDTO comment);

	public void commentDelete(CommentDTO comment);

	public CommentDTO checkCommentDeleteFlag(int id);

	public CommentDTO selectCommentById(int id);
}