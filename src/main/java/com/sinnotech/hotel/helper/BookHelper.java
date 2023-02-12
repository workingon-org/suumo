package com.sinnotech.hotel.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.util.Util;

/**
 * 예약 헬퍼
 * @author KimJeMin
 *
 */
public class BookHelper {

	public boolean filterIsAvaliableBookDate(List<BookingsDTO> theDatesOfTheRoom, BookingsDTO bookInfo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String Sstr = Util.DateForView(bookInfo.getStartDate());
			String Send = Util.DateForView(bookInfo.getEndDate());
			Date Dstr = sdf.parse(Util.DateForView(bookInfo.getStartDate()));
			Date Dend = sdf.parse(Util.DateForView(bookInfo.getEndDate()));
			for (BookingsDTO date : theDatesOfTheRoom) {
				Date strD = sdf.parse(date.getStartDate());
				Date endD = sdf.parse(date.getEndDate());
				String strS = sdf.format(strD);
				String endS = sdf.format(endD);
				if (Sstr.equals(strS) && Send.equals(endS))
					return false;
				else if (strD.after(Dstr) && endD.before(Dend))
					return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}
}
