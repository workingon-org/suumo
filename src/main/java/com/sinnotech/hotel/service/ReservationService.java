package com.sinnotech.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.ReservationDTO;

@Service
public interface ReservationService {

	List<ReservationDTO> getReservationList();
	
	ReservationDTO checkRoom(int max_count);
	
	int getReservationInsert(ReservationDTO ReservationDTO);
	
	ReservationDTO getRoomInfoDetail(int id);
	
	void insertReservation(ReservationDTO reservationDTO);
	
	
}
