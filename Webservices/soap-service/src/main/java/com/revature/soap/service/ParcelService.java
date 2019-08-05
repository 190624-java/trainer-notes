package com.revature.soap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.soap.beans.Parcel;
import com.revature.soap.data.ParcelRepository;

@Service
public class ParcelService {

	@Autowired
	private ParcelRepository repo;
	
	public Parcel save(Parcel parcel) {
		return repo.save(parcel);
	}
	
	public List<Parcel> findAll(){
		return repo.findAll();
	}
	
	public Parcel findById(int id) {
		return repo.findById(id).get();
	}
	
}
