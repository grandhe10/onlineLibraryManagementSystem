package com.demo.onlinebookborrowsystem.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.onlinebookborrowsystem.dao.BookDao;
import com.demo.onlinebookborrowsystem.dao.CategoryDao;
import com.demo.onlinebookborrowsystem.dto.BookRequestDto;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

	@Mock
	BookDao bookDao;

	@InjectMocks
	BookServiceImpl bookServiceImpl;

	@Mock
	CategoryDao categoryDao;
	
	
	@BeforeEach
	public void setUp() {

	}

	@Test
	public void getrequestsByEmployeeIdAndREquestId() {
		BookRequestDto bookRequestDto = new BookRequestDto();
		bookRequestDto.setAuthorName("ABCD");
		bookRequestDto.setBookTitle("book1");
		bookServiceImpl.getBooksByAuthorNameAndBookTitle(bookRequestDto);
		verify(bookDao).findByAuthorNameContainsAndBookTitleContains(bookRequestDto.getAuthorName(), bookRequestDto.getBookTitle());
	}
}