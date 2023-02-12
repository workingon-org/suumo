package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.CommentDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.mapper.BoardMapper;

/**
 * 게시판 DAO
 * @author JongIn Yoon
 *
 */
@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<BoardDTO> getBoardList(Paging paging) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.getBoardList(paging);
	}

	public List<BoardDTO> searchBoardList(Paging paging) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.searchBoardList(paging);
	}

	public BoardDTO boardDetail(Integer id) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.boardDetail(id);
	}

	public void boardForm(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
	}

	public void updateBoard(BoardDTO boardDTO) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.updateBoard(boardDTO);
	}

	public void deleteBoard(Integer id) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.deleteBoard(id);
	}

	public void insertBoard(BoardDTO boardDTO) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.insertBoard(boardDTO);
	}

	public Integer getAllBoardCount(Paging page) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.getAllBoardCount(page);
	}

	public Integer searchBoardListCount(Paging page) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.searchBoardListCount(page);
	}
	
	public List<CommentDTO> selectCommentList(Integer id) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.selectCommentList(id);
	}

	public boolean insertComment(CommentDTO comment) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int previousSize = getPreviousSize(comment.getBoardId(), mapper);
		mapper.insertComment(comment);
		return getAfterSizeAndResult(comment.getBoardId(), previousSize, mapper) == true;
	}
	
	public boolean updateComment(CommentDTO comment) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.updateComment(comment);
		return mapper.selectCommentById(comment.getId()).getContent().equals(comment.getContent());
	}
	
	private boolean getAfterSizeAndResult(int boardId, int previousSize, BoardMapper mapper) {
		List<CommentDTO> commentList = mapper.selectCommentList(boardId);
		int afterSize = 0;
		if (commentList != null) {
			afterSize = commentList.size();
			if (previousSize == afterSize - 1)
				return true;
			else
				return false;
		} else
			return false;
	}

	private int getPreviousSize(int boardId, BoardMapper mapper) {
		List<CommentDTO> commentList = mapper.selectCommentList(boardId);
		if (commentList != null) {
			return commentList.size();
		}
		return 0;
	}

	public boolean commentDelete(CommentDTO comment) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.commentDelete(comment);
		return mapper.checkCommentDeleteFlag(comment.getId()) != null;
	}
}