package com.sinnotech.hotel.util;

import javax.servlet.http.HttpServletRequest;

import com.sinnotech.hotel.dto.Paging;

/**
 * pj Util
 * 
 * @author KimJeMin
 *
 */
public class Util {

	public static String GET_RETURN_KIND;
	public static final String DATEFORMAT_FAIL_FORVIEW = "9999-12-30";
	public static final String DATEFORMAT_FAIL_FORDATE = "99991230";

	public static void setGET_RETURN_KIND(HttpServletRequest rq, String url, Paging page, String type) {
		if (type.equals("replace")) {
			url = "location.replace(\"" + url + page.searchPreviousPaging(page) + "\")";
		} else if (type.equals("href")) {
			url = "location.href=\"" + url + page.searchPreviousPaging(page) + "\"";
		} else if (type.equals("history.back")) {
			url = "history.back()";
		}
		rq.getSession().setAttribute("getReturnKind", url);
		GET_RETURN_KIND = url;
	}

	public static boolean CheckNumber(String str) {
		char check;
		if (str.equals("")) {
			// 문자열이 공백인지 확인
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			check = str.charAt(i);
			if (check < 48 || check > 58)
				return false;
		}
		return true;
	}

	public static String DateForView(String startDate) {
		if (startDate.length() == 8) {
			String yyyy = startDate.substring(0, 4);
			String mm = startDate.substring(4, 6);
			String dd = startDate.substring(6, 8);
			StringBuilder str = new StringBuilder();
			return str.append(yyyy + "-" + mm + "-" + dd).toString();
		}
		return DATEFORMAT_FAIL_FORVIEW;
	}

	public static String DateForDB(String startDate) {
		if (startDate.length() == 10) {
			String[] date = startDate.split("-");
			return date[0] + date[1] + date[2];
		}
		return DATEFORMAT_FAIL_FORDATE;
	}

}
