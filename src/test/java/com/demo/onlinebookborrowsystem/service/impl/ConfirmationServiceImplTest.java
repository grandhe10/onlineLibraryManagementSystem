package com.demo.onlinebookborrowsystem.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.onlinebookborrowsystem.dao.BookDao;
import com.demo.onlinebookborrowsystem.dao.CategoryDao;
import com.demo.onlinebookborrowsystem.dao.ConfirmationDao;
import com.demo.onlinebookborrowsystem.dao.UserDao;
import com.demo.onlinebookborrowsystem.dto.BorrowListDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationRequestDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationResponseDto;
import com.demo.onlinebookborrowsystem.model.BookStatus;
import com.demo.onlinebookborrowsystem.model.Confirmation;
import com.demo.onlinebookborrowsystem.model.User;

@ExtendWith(MockitoExtension.class)
public class ConfirmationServiceImplTest {

	@Mock
	BookDao bookDao;

	@InjectMocks
	ConfirmationServiceImpl confirmationServiceImpl;

	@Mock
	UserDao userDao;
	
	@Mock
	ConfirmationDao confirmationDao;
	
	@Mock
	CategoryDao categoryDao;
	
	@BeforeEach
	public void setUp() {

	}

	@Test
	public void borrowBookTest() {
		ConfirmationResponseDto confirmationResponseDto = new ConfirmationResponseDto();
		confirmationResponseDto.setMessage("Borrow request is successfully submitted");
		confirmationResponseDto.setStatusCode(202);
		List<ConfirmationRequestDto> confirmationRequestDtoList = new ArrayList<>();
		ConfirmationRequestDto confirmationRequestDto = new ConfirmationRequestDto();
		confirmationRequestDto.setBookId(1L);
		confirmationRequestDto.setFromDate("2020-07-01");
		confirmationRequestDto.setToDate("2020-07-04");
		confirmationRequestDtoList.add(confirmationRequestDto);
		User user = new User();
		user.setUserId(1L);
		Confirmation confirmation = new Confirmation();
		confirmation.setBookId(1L);
		confirmation.setFromDate(LocalDate.parse("2020-07-01"));
		confirmation.setToDate(LocalDate.parse("2020-07-04"));
		confirmation.setStatus(BookStatus.BORROW);
		confirmationServiceImpl.borrowBooks(confirmationRequestDtoList, 1L);
		confirmationDao.findByUserIdAndBookIdAndFromDate(1L, 1L, LocalDate.parse("2020-07-01"));
		verify(confirmationDao).findByUserIdAndBookIdAndFromDate(1L, 1L, LocalDate.parse("2020-07-01"));
		
	}
	
	 @Test
     public void getbookdetailsbyuserId() {
         BorrowListDto borrowlistDto = new BorrowListDto();
         List<BorrowListDto> borrowdtolist = new ArrayList<>();
         borrowdtolist.add(borrowlistDto);
         borrowlistDto.setAuthorName("gyu");
         borrowlistDto.setBookTitle("gs");
         borrowlistDto.setFromDate(LocalDate.parse("2020-06-29"));
         borrowlistDto.setToDate(LocalDate.parse("2020-06-30"));
         confirmationServiceImpl.getBorrowlistByUserId(1L);
         verify(confirmationDao).findAllByUserId(1L);
}
}