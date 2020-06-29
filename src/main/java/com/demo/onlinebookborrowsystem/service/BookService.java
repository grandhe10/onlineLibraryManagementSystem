package com.demo.onlinebookborrowsystem.service;

import com.demo.onlinebookborrowsystem.dto.BookListResponseDto;
import com.demo.onlinebookborrowsystem.dto.BookRequestDto;

public interface BookService {

	BookListResponseDto getBooksByAuthorNameAndBookTitle(BookRequestDto bookRequestDto);

}
