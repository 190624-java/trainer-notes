package com.revature.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public ModelAndView hello(HttpServletRequest request) {
		System.out.println(request.getParameter("pickle"));
		
		//call a service to do business logic... blah blah blah
		
		//return the view name and model to ViewResolver
		Map<String, String> model = new HashMap<>();
		model.put("data", request.getParameter("pickle"));
		return new ModelAndView("/static/hello.jsp", model);
	}
	
	@RequestMapping(value="/api", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody //tells spring, to just send this data in the response body,
	//skip the view resolver, we don't need it.
	//by DEFAULT Spring will automatically use Jackson
	public List<String> apiCall(){
		List<String> data = new ArrayList<>();
		data.add("Hello");
		data.add("World");
		data.add("Spring");
		return data;
	}
	
}
