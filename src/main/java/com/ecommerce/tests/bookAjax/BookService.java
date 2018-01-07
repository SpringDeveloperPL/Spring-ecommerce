package com.ecommerce.tests.bookAjax;

import java.util.List;

import org.springframework.stereotype.Service;


public interface BookService {

	public List<Book> searchBooksByMatch(String chars);
}
