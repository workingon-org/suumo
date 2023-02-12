package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sinnotech.hotel.dto.BoardDTO;
import com.sinnotech.hotel.dto.ReservationDTO;

@Mapper
public interface ReservationMapper {

	List<ReservationDTO> getReservationList();

	public void insertReservation(ReservationDTO reservationDTO);
}
