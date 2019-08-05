package com.revature.soap.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.revature.soap.beans.Parcel;
import com.revature.soap.service.ParcelService;

@Controller
@WebService
public class SoapParcelService {
	
	@Autowired
	private ParcelService service;

	@WebMethod
	public Parcel save(Parcel parcel) {
		return service.save(parcel);
	}
	
	@WebMethod
	public List<Parcel> findAll(){
		return service.findAll();
	}
	
	@WebMethod
	public Parcel findById(int id) {
		return service.findById(id);
	}
}
