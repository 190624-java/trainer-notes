package com.revature.soap.soap;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapConfig {

	@Autowired
	private Bus cxfBus;
	
	/*
	 * SEI - service endpoint interface (WSDL)
	 * SIB - service implementing bean (our service implementation)
	 */
	@Autowired
	private SoapParcelService serviceImpl;
	
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(cxfBus, serviceImpl);
		endpoint.publish("/parcel");
		return endpoint;
	}
}
