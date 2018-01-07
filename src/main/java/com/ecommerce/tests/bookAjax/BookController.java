package com.ecommerce.tests.bookAjax;

import java.lang.annotation.Retention;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/booksSearch")
	public String bookView(Model model) { 
		
		return "booksSearch";
	}
	
	@RequestMapping("/booksSearch.do")
	public @ResponseBody List<Book> performBookSearch(@RequestParam("CHARS")String chars) {
		
		if(chars.length()<=1) {
			return null;
		}
		return bookService.searchBooksByMatch(chars);
	}
}

