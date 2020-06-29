package com.demo.onlinebookborrowsystem.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.onlinebookborrowsystem.dto.BorrowListDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationRequestDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationResponseDto;
import com.demo.onlinebookborrowsystem.service.ConfirmationService;

@RestController
public class ConfirmationController {
	@Autowired
	ConfirmationService confirmationService;
	@PostMapping("/users/{userId}/confirmations")
	public ResponseEntity<ConfirmationResponseDto> borrowBooks(@RequestBody List<ConfirmationRequestDto> confirmationRequestDtoList,@PathVariable("userId") Long userId)
	{
		return new ResponseEntity<>(confirmationService.borrowBooks(confirmationRequestDtoList,userId),HttpStatus.OK);
	}

	private static Log logger = LogFactory.getLog(ConfirmationController.class);
    @Autowired 
    ConfirmationService confirmationservice;
    /**This method return all the list of borrowed books by user
     * @param userId
     * @return list of borrowed books by user
     */
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<BorrowListDto>> getListOfBorrowedByuserId(@PathVariable("userId") Long userId) {
        logger.info("Inside getborrowbooksbyuserId confirmationController");
        return new ResponseEntity<List<BorrowListDto>>(confirmationService.getBorrowlistByUserId(userId),HttpStatus.OK);
    }
}
