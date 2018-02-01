package com.example.outinkirjakauppa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.outinkirjakauppa.domain.Book;
import com.example.outinkirjakauppa.domain.BookRepository;

@SpringBootApplication
public class OutinkirjakauppaApplication {
	private static final Logger log = LoggerFactory.getLogger(OutinkirjakauppaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OutinkirjakauppaApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			log.info("save few books");
			repository.save(new Book("Kafka on the Shore", "Haruki Murakami", "9789724616469", 2002, 14.91 ));
			repository.save(new Book("1Q84", "Haruki Murakami", "978972345269", 2010, 21.99 ));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		
		};
	}
	
}
