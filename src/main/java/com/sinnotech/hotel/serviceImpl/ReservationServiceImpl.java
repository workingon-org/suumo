package com.sinnotech.hotel.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.controller.ReservationController;
import com.sinnotech.hotel.dao.ReservationDAO;
import com.sinnotech.hotel.dto.ReservationDTO;
import com.sinnotech.hotel.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	ReservationDAO reservationDAO;
	
	@Override
	public List<ReservationDTO> getReservationList() {

		return reservationDAO.getReservationList();
	}

	@Override
	public ReservationDTO checkRoom(int max_count) {
		// TODO Auto-generated method stub
		return  reservationDAO.checkRoom();
	}

	@Override
	public int getReservationInsert(ReservationDTO ReservationDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReservationDTO getRoomInfoDetail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertReservation(ReservationDTO reservationDTO) {
		String str = reservationDTO.getCheckin();
		String str2 = reservationDTO.getCheckout();
	       str = str.replaceAll("-","");
	       str2 = str2.replaceAll("-","");
		        reservationDTO.setCheckin(str);
		        reservationDTO.setCheckout(str);
		reservationDAO.insertReservation(reservationDTO);
	}


}
