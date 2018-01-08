package com.ecommerce.tests.bookAjax;

import java.util.List;


public interface BookService {

	public List<Book> searchBooksByMatch(String chars);
}
