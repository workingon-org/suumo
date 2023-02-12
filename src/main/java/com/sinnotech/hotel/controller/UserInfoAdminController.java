package com.sinnotech.hotel.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sinnotech.hotel.dao.UserPageDTO;
import com.sinnotech.hotel.dto.SetPaging;
import com.sinnotech.hotel.dto.UsersDTO;
import com.sinnotech.hotel.service.UserInfoAdminService;
import com.sinnotech.hotel.util.Message;

/**
 * 관리자 유저정보 컨트롤러
 * 
 * @author sunjungkim
 * 
 */

@Controller
@RequestMapping("/admin/userInfo")
public class UserInfoAdminController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoAdminController.class);

	private final static String Search = ADMIN_BASE_PATH + "userInfo/userInfoSearch";
	private String PreSearch;
	@Autowired
	private UserInfoAdminService userInfoAdminService;
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * 초기화면
	 * 
	 * @param model
	 * @param page
	 * @return 검색화면
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String init(Model model, SetPaging page) {
		logger.info("UserInfoAdminController.userList() - START");

		List<UsersDTO> userInfoInput = new ArrayList<UsersDTO>();
		//전체 고객정보 
		userInfoInput = userInfoAdminService.getUsersInfoAllList();
		//전체 고객정보 수 
		int total = userInfoAdminService.getUsersInfoAllListCount();
		//전체페이지
		page.setTotal(total);
		int totalPage = (int) page.getTotal();
		//시작페이지 
		page.setStartPage(1);
		//현재페이지
		page.setCurrentPage(1);
		//페이징처리 페이지 수 최대 5 
		//전체 페이지 수가 5미만인 경우 전체 페이지 수로 표시
		page.setEndPage(totalPage > 5 ? 5 : (int) totalPage);
		model.addAttribute("page", page);
		model.addAttribute("userInfoList", userInfoInput);

		logger.info("UserInfoAdminController.userList() - END");
		return Search;
	}

	/**
	 * 유저검색기능
	 * 
	 * @param model
	 * @param page
	 * @param rq
	 * @return 검색화면
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model, SetPaging page, HttpServletRequest rq) {
		logger.info("UserInfoAdminController.search() - START");
		String searchType = rq.getParameter("searchType");
		String currentPage;
		String searchKeyword = rq.getParameter("searchkeyword");
		//검색유형 설정
		if (rq.getParameterValues("searchType") != null) {
			searchType = rq.getParameter("searchType");
			page.setSearchType(searchType);
		}
		//검색어 설정
		if (rq.getParameter("searchKeyword") != null) {
			searchKeyword = rq.getParameter("searchKeyword");
			page.setSearchKeyword(searchKeyword);
		}
		//현재페이지 설정
		if (rq.getParameter("currentPage") != null) {
			currentPage = rq.getParameter("currentPage");
			page.setCurrentPage(Integer.parseInt(currentPage));
		}
		//재검색시 페이지설
		if (PreSearch != null && !PreSearch.equals(page.getSearchKeyword())) {
			page.setCurrentPage(1);
			page.setStartPage(1);
		}
		PreSearch = page.getSearchKeyword();
		//검색결과 설정
		UserPageDTO userInfoInput = userInfoAdminService.getUsersInfoList(page);
		model.addAttribute("page", userInfoInput.getPaging());
		model.addAttribute("userInfoList", userInfoInput.getUsersDTOList());

		logger.info("UserInfoAdminController.search() - END");
		return Search;
	}

	/**
	 * 패스워드변경
	 * 
	 * @param id
	 * @param rq
	 * @param rs
	 * @param model
	 * @param email
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/passwordReset/{id}", method = RequestMethod.GET)
	public String reset(@PathVariable("id") Integer id, HttpServletRequest rq, HttpServletResponse rs, Model model,
			String email) throws IOException {
		logger.info("UserInfoAdminController.passwordReset() - START");
		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(message, true, "UTF-8");
			//임시비밀번호 생성
			String newPassword = UUID.randomUUID().toString().substring(0, 5);
			//패스워드갱신
			boolean result = userInfoAdminService.updateUserPassword(newPassword, id);
			//갱신된 패스워드 발송
			if (result) {
				msgHelper.setSubject(""); // 이메일의 제목
				msgHelper.setText("임시비밀번호는 " + newPassword + "입니다."); // 이메일의 내용
				msgHelper.setTo(email);
				msgHelper.setFrom("");
				mailSender.send(message);// 메일을 송부
				logger.info("UserInfoAdminController.passwordReset() - END");
				return "Success";
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		logger.info("UserInfoAdminController.passwordReset() - END");
		return "Fail";
	}

	/**
	 * 유저삭제처리
	 * 
	 * @param id
	 * @param model
	 * @param rq
	 * @param redirect
	 * @return 처리화면
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, Model model, HttpServletRequest rq,
			RedirectAttributes redirect) throws UnsupportedEncodingException {
		logger.info("UserInfoAdminController.delete() - START");
		String searchType = "", searchKeyword = "", currentPage = "";
		if (rq.getParameter("searchType") != null)
			searchType = rq.getParameter("searchType");
		if (rq.getParameter("searchKeyword") != null)
			searchKeyword = rq.getParameter("searchKeyword");
		if (rq.getParameter("currentPage") != null)
			currentPage = rq.getParameter("currentPage");
		//유저삭제처리
		boolean result = userInfoAdminService.deleteUser(id);
		//유저삭제 메시지띄우기
		if (result) {
			//성공시
			redirect.addFlashAttribute("message", Message.DELETE_SUCCEED);
		} else {
			//실패시
			redirect.addFlashAttribute("message", Message.DELETE_FALL);
		}
		logger.info("UserInfoAdminController.delete() - END");
		return "redirect:/admin/userInfo/search?searchType=" + searchType + "&searchKeyword=" + searchKeyword
				+ "&currentPage=" + currentPage + "&type=delete";
	}

}
