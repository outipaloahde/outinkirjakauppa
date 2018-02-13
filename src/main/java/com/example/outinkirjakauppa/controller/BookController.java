package com.example.outinkirjakauppa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public @ResponseBody List<Book> listRest(){
		return (List<Book>)repository.findAll();
	}
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId){
		return repository.findOne(bookId);
	
	}
	
	@RequestMapping("/add")
	public String add(Model model){
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping("/save")
	public String save(Book book){
		repository.save(book);
		return "redirect:booklist";
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		repository.delete(id);
		return "redirect:../booklist";
	}
	
	
}
