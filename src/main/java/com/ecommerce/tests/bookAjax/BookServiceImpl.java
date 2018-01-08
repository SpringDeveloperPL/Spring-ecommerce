package com.ecommerce.tests.bookAjax;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

	@Override
	public List<Book> searchBooksByMatch(String chars) {
		
		System.out.println("looking for " +chars);
		
		Book book2 = new Book("Some tittle");
		Book book1 = new Book("chujowa ksiazka");		
		Book book3 = new Book("chuj nie ksiazka");		
		List<Book> boookList = new ArrayList<>();
		List<Book> boookToReturn = new ArrayList<>();
		boookList.add(book1);
		boookList.add(book2);	
		boookList.add(book3);
		
		for (Book book : boookList) {
			
			if(book.getTitle().toUpperCase().contains(chars.toUpperCase())) {
				boookToReturn.add(book);
			}
		}
				
		return boookToReturn;
	}

}
