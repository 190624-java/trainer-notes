package com.revature.soap.client;

import java.util.List;

import com.revature.soap.soap.Parcel;
import com.revature.soap.soap.SoapParcelService;
import com.revature.soap.soap.SoapParcelServiceService;

public class SoapClient {

	private SoapParcelService client = new SoapParcelServiceService()
			.getPort(SoapParcelService.class);
	
	public List<Parcel> findAll(){
		return client.findAll();
	}
	
	public Parcel findById(int id) {
		return client.findById(id);
	}
	
	public Parcel save(Parcel parcel) {
		return client.save(parcel);
	}

}
