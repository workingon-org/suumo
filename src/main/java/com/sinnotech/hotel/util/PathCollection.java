package com.sinnotech.hotel.util;

/**
 * Path 컬렉션
 * 
 * @author KimJeMin
 *
 */
public interface PathCollection {

	// Model
	final String SELECTEDOPTION = "selectedOption";
	final String OPTIONS = "options";
	final String PAGING = "paging";
	final String BOOKLIST = "bookList";
	final String REDRIRECT = "redirect:";
	final String MESSAGE = "message";
	final String BOOK = "book";
	final String BOOK$ = "book/";
	final String $BOOK = "/book";
	final String FORM = "form";
	final String READONLY = "readonly";
	final String DISABLED = "disabled";
	final String DETAIL = "detail";
	final String ROOMINFOLIST = "roomInfoList";
	final String REPLACE = "replace";
	final String HISTORY_BACK = "history.back";

	// URL

	final String $ = "/";
	final String $ADMIN = "/admin";
	final String $ADMIN$BOOK$LIST = $ADMIN + "/book/list";
	final String $ADMIN$CALENDAR$ = $ADMIN + "/calendar/";

}
