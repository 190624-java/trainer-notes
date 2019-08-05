package com.revature.soap;

import com.revature.soap.client.SoapClient;
import com.revature.soap.soap.Parcel;

public class Test {

	public static void main(String[] args) {
		SoapClient client = new SoapClient();
		
		//save some parcels
		Parcel p1 = new Parcel();
		p1.setTracking("1850376930285769");
		p1.setWeight(100.0);
		
		Parcel p2 = new Parcel();
		p2.setTracking("2958699637586058");
		p2.setWeight(46.2);
		
		//save these
		p1 = client.save(p1);
		p2 = client.save(p2);
		
		//find one
		System.out.println(client.findById(1));
		
		//find all
		System.out.println(client.findAll());

	}

}
