package com.expedia.boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelAggregationController {

	@Autowired
	private HotelAggregationService service;

	@GetMapping("/hotel/{company}")
	public ResponseEntity<Hotel> findByCompany(@PathVariable String company) {
		Hotel hotel = null;
		switch (company) {
		case "kyle":
			hotel = service.findKylesHotel();
			break;
		case "paul":
			hotel = service.findPaulsHotel();
			break;
		case "jason":
			hotel = service.findJasonsHotel();
			break;
		default:
			hotel = service.findHotel();
			break;
		}
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}

	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> findAllHotels(){
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.addAll(service.findAllPaulsHotels());
		hotels.addAll(service.findAllKylesHotels());
		hotels.addAll(service.findAlJasonsHotels());
		return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
	}
	
}