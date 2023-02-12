package com.sinnotech.hotel.dto;

import java.util.Date;

/**
 * 게시판 댓글 DTO
 * @author JongIn Yoon
 *
 */
public class CommentDTO {
	private int id;				// 해당 댓글이 있는 게시글의 번호
	private int boardId;		// 댓글 번호
	private String name;		// 댓글을 쓴 작성자
	private String content;		// 댓글 내용
	private String deletFlag;	// 댓글 삭제유무
	private Date createdAt;		// 댓글 작성한 시간 
	private String updatedAt;	// 댓글 작성한 시간 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDeletFlag() {
		return deletFlag;
	}
	public void setDeletFlag(String deletFlag) {
		this.deletFlag = deletFlag;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}