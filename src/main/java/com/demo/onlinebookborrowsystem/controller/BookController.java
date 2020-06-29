package com.demo.onlinebookborrowsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.onlinebookborrowsystem.dto.BookListResponseDto;
import com.demo.onlinebookborrowsystem.dto.BookRequestDto;
import com.demo.onlinebookborrowsystem.service.BookService;

/**
 * @author Suma
 * This controller is used to get the requests and display response based on the request
 *
 */
@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	/**
	 * This method is used to get the list of books using the authorName and book title
	 * @param bookRequestDto
	 * @return list of books
	 */
	@PostMapping("/books")
	public ResponseEntity<BookListResponseDto> getBooksByAuthorNameAndBookTitle(@Valid @RequestBody BookRequestDto bookRequestDto)
	{
		return new ResponseEntity<>(bookService.getBooksByAuthorNameAndBookTitle(bookRequestDto),HttpStatus.OK);
	}

}
