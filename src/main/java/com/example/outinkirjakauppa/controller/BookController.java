package com.example.outinkirjakauppa.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.outinkirjakauppa.domain.Book;
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
	public String listofbooks(Model model){
		model.addAttribute("list", repository.findAll());
	
		return "booklist";
	}
	
}
