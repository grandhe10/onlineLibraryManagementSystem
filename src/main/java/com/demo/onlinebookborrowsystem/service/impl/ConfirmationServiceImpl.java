package com.demo.onlinebookborrowsystem.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.onlinebookborrowsystem.dao.BookDao;
import com.demo.onlinebookborrowsystem.dao.ConfirmationDao;
import com.demo.onlinebookborrowsystem.dto.ConfirmationRequestDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationResponseDto;
import com.demo.onlinebookborrowsystem.model.BookStatus;
import com.demo.onlinebookborrowsystem.model.Books;
import com.demo.onlinebookborrowsystem.model.Confirmation;
import com.demo.onlinebookborrowsystem.service.ConfirmationService;

@Service
public class ConfirmationServiceImpl implements ConfirmationService {

	 Log logger = LogFactory.getLog(ConfirmationServiceImpl.class);
	@Autowired
	ConfirmationDao confirmationDao;
	
	@Autowired
	BookDao bookDao;

	@Override
	public ConfirmationResponseDto borrowBooks(List<ConfirmationRequestDto> confirmationRequestDtoList, Long userId) {

		ConfirmationResponseDto confirmationResponseDto = new ConfirmationResponseDto();	
		
		if(confirmationRequestDtoList.size()>3)
		{
			confirmationResponseDto.setMessage("You cannot borrow more than 3 books at a time");
			confirmationResponseDto.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
			return confirmationResponseDto;
		}
		
		List<ConfirmationRequestDto> confirmationList = confirmationRequestDtoList.stream().map(confirmationRequestDto-> validate(confirmationRequestDto,userId)).collect(Collectors.toList());
		
		if((confirmationList.contains(null)))
		{
		
		confirmationResponseDto.setMessage("You have already borrowed any of these books/check your duration it should be not more than 7 days");
		confirmationResponseDto.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
		return confirmationResponseDto;
		}
		{
			
			confirmationList.stream().map(confirmation -> validateRequest(confirmation, userId)).collect(Collectors.toList());
		
		confirmationResponseDto.setMessage("Borrow request is successfully submitted");
		confirmationResponseDto.setStatusCode(HttpStatus.CREATED.value());
		return confirmationResponseDto;
		}
	}
	
	private ConfirmationRequestDto validate(ConfirmationRequestDto confirmationRequestDto, Long userId)
	{
		ConfirmationResponseDto confirmationResponseDto = new ConfirmationResponseDto();
		
		Optional<Confirmation> confirmationOptional = confirmationDao.findByUserIdAndBookIdAndFromDate(userId,
				confirmationRequestDto.getBookId(), LocalDate.parse(confirmationRequestDto.getFromDate()));
		
		Optional<Books> bookOptional = bookDao.findByBookId(confirmationRequestDto.getBookId());
		
		logger.info("entered validate method");
		LocalDate fromDate = LocalDate.parse(confirmationRequestDto.getFromDate());
		LocalDate toDate = LocalDate.parse(confirmationRequestDto.getToDate());
		long days = ChronoUnit.DAYS.between(fromDate, toDate);
		
		if(fromDate.isBefore(LocalDate.now().plusDays(3))&&days<=7&&!confirmationOptional.isPresent()&&bookOptional.isPresent())
		{
			logger.info(fromDate.isBefore(LocalDate.now().plusDays(2))&&days<=7&&!confirmationOptional.isPresent()&&bookOptional.isPresent());
			confirmationResponseDto.setStatusCode(HttpStatus.OK.value());
			return confirmationRequestDto;
		}
		else
		{
			
			return null;
		}
		
	}

	private ConfirmationResponseDto validateRequest(ConfirmationRequestDto confirmationRequestDto, Long userId) {

		ConfirmationResponseDto confirmationResponseDto = new ConfirmationResponseDto();
		
		logger.info("entered validateRequest method");
		
			Confirmation confirmation = new Confirmation();
			confirmation.setBookId(confirmationRequestDto.getBookId());
			confirmation.setFromDate(LocalDate.parse(confirmationRequestDto.getFromDate()));
			confirmation.setToDate(LocalDate.parse(confirmationRequestDto.getToDate()));
			confirmation.setUserId(userId);
			confirmation.setStatus(BookStatus.BORROW);
			confirmationDao.save(confirmation);
			confirmationResponseDto.setStatusCode(HttpStatus.CREATED.value());
			return confirmationResponseDto;

	}
}
