package com.sinnotech.hotel.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinnotech.hotel.dao.ReservationDAO;
import com.sinnotech.hotel.dto.NoticeDTO;
import com.sinnotech.hotel.dto.ReservationDTO;
import com.sinnotech.hotel.dto.TestDto;
import com.sinnotech.hotel.service.NoticeService;
import com.sinnotech.hotel.service.ReservationService;
import com.sinnotech.hotel.util.Constants;
import com.sinnotech.hotel.util.Util;

@Controller
public class ReservationController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	private final String ReservationLIST_FORM = CLIENT_BASE_PATH+"Reservation/ReservationList";
	private final String ReservationLIST2_FORM = CLIENT_BASE_PATH+"Reservation/ReservationList2";
	private final String ReservationLIST3_FORM = CLIENT_BASE_PATH+"Reservation/ReservationList3";
	private final String ReservationLIST4_FORM = CLIENT_BASE_PATH+"Reservation/ReservationList4";
	private final String HOME = CLIENT_BASE_PATH+"Reservation/ReservationList";
	
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value = "reservation", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView(ReservationLIST_FORM);
		return model;
	}
	
	@RequestMapping(value = "ReservationList2", method = RequestMethod.POST)
	public String reservation2(HttpServletRequest request, HttpServletResponse response) {
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		int adults = Integer.parseInt(request.getParameter("adults"));
		int kids = Integer.parseInt(request.getParameter("kids"));	
		request.setAttribute("checkin", checkin);
		request.setAttribute("checkout", checkout);
		request.setAttribute("adults", adults);
		request.setAttribute("kids", kids);
		
		int max_count = adults+kids;
		System.out.println("Max_count : " + max_count);
		
		
		
		return ReservationLIST2_FORM;
	}
	
	@RequestMapping(value = "ReservationList3", method = RequestMethod.POST)
	public String reservation3(HttpServletRequest request, HttpServletResponse response) {
		String roomtype = request.getParameter("roomtype");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		int adults = Integer.parseInt(request.getParameter("adults"));
		int kids = Integer.parseInt(request.getParameter("kids"));	
		request.setAttribute("roomtype", roomtype);
		request.setAttribute("checkin", checkin);
		request.setAttribute("checkout", checkout);
		request.setAttribute("adults", adults);
		request.setAttribute("kids", kids);
		

		
		
		return ReservationLIST3_FORM;
	}
	
	@RequestMapping(value = "reserveroom", method = RequestMethod.POST)
	public String reserveroom(ReservationDTO reservationDTO, Model model) {
		logger.info("예약");
		logger.info(reservationDTO.getCheckin());
		reservationService.insertReservation(reservationDTO);
		return ReservationLIST4_FORM;
	}


	
}