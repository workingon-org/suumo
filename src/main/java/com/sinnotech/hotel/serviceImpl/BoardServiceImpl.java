package com.sinnotech.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.BoardDAO;
import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.CommentDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.helper.PagingHelper;
import com.sinnotech.hotel.service.BoardService;

/**
 * 게시판 ServiceImpl
 * @author JongIn Yoon
 *
 */
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private PagingHelper helper;

	@Override
	public List<BoardDTO> getBoardList(Paging page) {
		page.setTotalCount(boardDAO.getAllBoardCount(page));
		page.setStartPage(1);
		page.setCurrentPage(1);
		page = helper.fliterPaing(page);
		page.setEndPage(page.getTotalPage() > 5 ? 5 : (int) page.getTotalPage());
		return boardDAO.getBoardList(page);
	}

	@Override
	public List<BoardDTO> searchBoardList(Paging page) {
		page.setTotalCount(boardDAO.searchBoardListCount(page));
		page = helper.fliterPaing(page);
		return boardDAO.searchBoardList(page);
	}

	@Override
	public BoardDTO boardDetail(Integer id) {
		return boardDAO.boardDetail(id);
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) {
		boardDAO.insertBoard(boardDTO);
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) {
		boardDAO.updateBoard(boardDTO);
	}

	@Override
	public void deleteBoard(Integer id) {
		boardDAO.deleteBoard(id);
	}

	@Override
	public List<CommentDTO> selectCommentList(Integer id) {
		return boardDAO.selectCommentList(id);
	}

	@Override
	public boolean insertComment(CommentDTO comment) {
		return boardDAO.insertComment(comment);
	}

	@Override
	public boolean updateComment(CommentDTO comment) {
		return boardDAO.updateComment(comment);
	}

	@Override
	public boolean commentDelete(CommentDTO comment) {
		return boardDAO.commentDelete(comment);
	}
}
