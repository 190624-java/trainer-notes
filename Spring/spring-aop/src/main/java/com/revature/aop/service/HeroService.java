package com.revature.aop.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class HeroService {

	public String getHeroes() {
		return "all heroes";
	}
	
	public String getPaladins() {
		return "only paladins";
	}
	
	public int getHeroCount() {
		System.out.println("inside of getHeroCount()");
		return 100;
	}
	
	public int getHeroCount(String type) {
		return new Random().nextInt();
	}
	
	public String search() {
		if(new Random().nextInt() > 0) {
			return "Found!";
		} else {
			throw new RuntimeException();
		}
	}
	
	public String findOne(String hero) {
		if(new Random().nextInt() > 0) {
			return "Found " + hero;
		} else {
			throw new RuntimeException();
		}
	}
	
}
