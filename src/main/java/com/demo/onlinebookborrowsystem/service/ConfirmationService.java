package com.demo.onlinebookborrowsystem.service;

import java.util.List;

import com.demo.onlinebookborrowsystem.dto.BorrowListDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationRequestDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationResponseDto;

/**
 * @author Suma,Lahari
 *
 */
public interface ConfirmationService {

	/**
	 * This method is used to send a book borrow request 
	 * @param confirmationRequestDtoList
	 * @param userId
	 * @return ConfirmationResponseDto
	 */
	ConfirmationResponseDto borrowBooks(List<ConfirmationRequestDto> confirmationRequestDtoList,Long userId);
	
	 /**
	  * This method is used to get the list of borrowed books 
     * @param userId
     * @return List<BorrowListDto>
     */
    public List<BorrowListDto> getBorrowlistByUserId(Long userId);

}
