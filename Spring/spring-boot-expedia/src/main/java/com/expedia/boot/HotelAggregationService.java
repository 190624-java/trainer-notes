package com.expedia.boot;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class HotelAggregationService implements InitializingBean {

	@Autowired
	private RestTemplateBuilder builder;
	private RestTemplate kyleRestTemplate;
	private RestTemplate paulRestTemplate;
	private RestTemplate jasonRestTemplate;
	private RestTemplate ec2RestTemplate;
	
	public void afterPropertiesSet() throws Exception {
		kyleRestTemplate = builder.rootUri("http://192.168.51.84:9595").build();
		paulRestTemplate = builder.rootUri("http://192.168.51.223:9595").build();
		jasonRestTemplate = builder.rootUri("http://192.168.51.109:9595").build();
		ec2RestTemplate = builder.rootUri("http://34.238.71.23:9595").build();
	}
	
	public Hotel findHotel() {
		return ec2RestTemplate.getForEntity("/api/v1/rooms/room/1", Hotel.class)
		.getBody();
	}
	
	public Hotel findKylesHotel() {
		return kyleRestTemplate.getForEntity("/api/v1/rooms/room/1", Hotel.class)
				.getBody();
	}
	
	public Hotel findPaulsHotel() {
		return paulRestTemplate.getForEntity("/api/v1/rooms/room/1", Hotel.class)
				.getBody();
	}
	
	public Hotel findJasonsHotel() {
		return jasonRestTemplate.getForEntity("/api/v1/rooms/room/1", Hotel.class)
				.getBody();
	}

	public List<Hotel> findAllKylesHotels(){
		List<Hotel> hotels = null;
		try {
			hotels = kyleRestTemplate.exchange(
					RequestEntity.get(new URI("http://192.168.51.84:9595/api/v1/rooms/"))
					.build(),
					new ParameterizedTypeReference<List<Hotel>>() {}).getBody();
			return hotels;
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Hotel> findAllPaulsHotels(){
		List<Hotel> hotels = null;
		try {
			hotels = paulRestTemplate.exchange(
					RequestEntity.get(new URI("http://192.168.51.223:9595/api/v1/rooms/"))
					.build(),
					new ParameterizedTypeReference<List<Hotel>>() {}).getBody();
			return hotels;
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Hotel> findAlJasonsHotels(){
		List<Hotel> hotels = null;
		try {
			hotels = jasonRestTemplate.exchange(
					RequestEntity.get(new URI("http://192.168.51.109:9595/api/v1/rooms/"))
					.build(),
					new ParameterizedTypeReference<List<Hotel>>() {}).getBody();
			return hotels;
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
}
