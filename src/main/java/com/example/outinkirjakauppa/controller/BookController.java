package com.example.outinkirjakauppa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.outinkirjakauppa.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping("/index")
	public String home(){
		return "index";
	}
	
	@RequestMapping("/booklist")
	public String listofbooks(){
		
		
		
		
		return "booklist";
	}
	
	
	

}
