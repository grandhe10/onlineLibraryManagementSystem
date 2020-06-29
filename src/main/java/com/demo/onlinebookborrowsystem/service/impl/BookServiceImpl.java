package com.demo.onlinebookborrowsystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.onlinebookborrowsystem.dao.BookDao;
import com.demo.onlinebookborrowsystem.dao.CategoryDao;
import com.demo.onlinebookborrowsystem.dto.BookListResponseDto;
import com.demo.onlinebookborrowsystem.dto.BookRequestDto;
import com.demo.onlinebookborrowsystem.dto.BookResponseDto;
import com.demo.onlinebookborrowsystem.model.Books;
import com.demo.onlinebookborrowsystem.model.Category;
import com.demo.onlinebookborrowsystem.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	@Autowired
	CategoryDao categoryDao;

	@Override
	public BookListResponseDto getBooksByAuthorNameAndBookTitle(BookRequestDto bookRequestDto) {
		BookListResponseDto bookListResponseDto = new BookListResponseDto();
		Optional<List<Books>> booksOptionalList = bookDao.findByAuthorNameContainsAndBookTitleContains(
				bookRequestDto.getAuthorName(), bookRequestDto.getBookTitle());
		if (!booksOptionalList.isPresent()) {
			bookListResponseDto.setMesaage("No books available matching your request");
			bookListResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
			return bookListResponseDto;
		}
		List<BookResponseDto> bookList = booksOptionalList.get().stream().map(books -> getBookResponseDto(books)).collect(Collectors.toList());
			bookListResponseDto.setBookResponseDtoList(bookList);
			bookListResponseDto.setMesaage("Please find the list of available books");
			bookListResponseDto.setStatusCode(HttpStatus.OK.value());
			return bookListResponseDto;
		
		
	}

	private BookResponseDto getBookResponseDto(Books books) {
		BookResponseDto bookResponseDto = new BookResponseDto();
		Optional<Books> bookOptional = bookDao.findByAuthorNameAndBookTitle(books.getAuthorName(),
				books.getBookTitle());

		if (bookOptional.isPresent()) {
			Optional<Category> categoryOptional = categoryDao.findByCategoryId(bookOptional.get().getCategoryId());
			if (categoryOptional.isPresent()) {
				bookResponseDto.setAuthorName(bookOptional.get().getAuthorName());
				bookResponseDto.setBookTitle(bookOptional.get().getBookTitle());
				bookResponseDto.setCategoryName(categoryOptional.get().getCategoryName());
				bookResponseDto.setBookId(bookOptional.get().getBookId());
			} 
			else
				return null;

		} 
		else
			return null;
		return bookResponseDto;
	}
}