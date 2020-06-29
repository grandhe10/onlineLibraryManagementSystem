package com.demo.onlinebookborrowsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
