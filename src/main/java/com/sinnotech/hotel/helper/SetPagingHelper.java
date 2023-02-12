package com.sinnotech.hotel.helper;

import org.springframework.stereotype.Component;

import com.sinnotech.hotel.dto.SetPaging;

/**
 * 페이징 helper
 * 
 * @author sunjungkim
 *
 */
@Component
public class SetPagingHelper {

	public SetPaging userPaging(SetPaging page) {
		if (page.getCurrentPage() < 0)
			page.setCurrentPage(1);
		if (page.getCurrentPage() > 3) {
			//현재페이지가 3보다 큰경우 현재페이지를 중심으로 앞에 2페이지 설정.
			page.setStartPage(page.getCurrentPage() - 2);
			//현재페이지와 전체페이지-2가 같은 경우 마지막페이지는 전체페이지
			if (page.getCurrentPage() >= page.getTotal() - 2) {
				page.setEndPage((int) page.getTotal());
			} else {
				page.setEndPage(page.getCurrentPage() + 2);
			}
			//현재페이지가 3보다 작은 경우 
		} else {
			//시작페이지1설정
			page.setStartPage(1);
			//현재페이지가 전체페이지2와 크거나 같은경우 마지막페이지는 전체페이지
			if (page.getCurrentPage() >= page.getTotal() - 2) {
				page.setEndPage((int) page.getTotal());
			} else {
				if (page.getTotal() >= 5)
					page.setEndPage(5);
				else
					page.setEndPage((int) page.getTotal());
			}
		}
		//현재페이지가 전체페이지보다 큰 경우 현재페이지는 전체페이지
		if (page.getCurrentPage() > page.getTotal())
			page.setCurrentPage((int) page.getTotal());

		return page;
	}

}
