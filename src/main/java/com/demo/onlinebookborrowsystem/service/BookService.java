package com.demo.onlinebookborrowsystem.service;

import com.demo.onlinebookborrowsystem.dto.BookListResponseDto;
import com.demo.onlinebookborrowsystem.dto.BookRequestDto;

/**
 * @author Suma
 *
 */
public interface BookService {

	/**
	 * This method is used to get BooksBy AuthorName and bookTtile
	 * @param bookRequestDto
	 * @return BookListResponseDto
	 */
	BookListResponseDto getBooksByAuthorNameAndBookTitle(BookRequestDto bookRequestDto);

}
