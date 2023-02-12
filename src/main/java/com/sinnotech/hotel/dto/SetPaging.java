package com.sinnotech.hotel.dto;

/**
 * @author sunjungkim
 * 
 */
public class SetPaging {

	private String searchType;
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
		if (searchType.equals("name")) {
			name = "selected";
		}
		if (searchType.equals("phone")) {
			phone = "selected";
		}
		if (searchType.equals("email")) {
			email = "selected";
		}
	}

	private String searchKeyword;
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	private String name;
	private String phone;
	private String email;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	private Integer currentPage;
	private Integer endPage;
	private double total;
	private Integer startPage;

	public SetPaging() {
	}
	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		if (startPage != null && startPage != 0) {
			this.startPage = startPage;
		} else {
			this.startPage = 1;
		}
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		if (currentPage != null && currentPage != 0) {
			this.currentPage = currentPage;
		} else {
			this.currentPage = 1;
		}
	}
	public Integer getEndPage() {
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	public double getTotal() {
		return total;
	}
	// 전체페이지 수 계산 (한 페이지당 고객정보는 10명)
	public void setTotal(double total) {
		this.total = Math.ceil(total /10);
	}
}
