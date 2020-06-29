package com.demo.onlinebookborrowsystem.service;

import java.util.List;

import com.demo.onlinebookborrowsystem.dto.ConfirmationRequestDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationResponseDto;

public interface ConfirmationService {

	ConfirmationResponseDto borrowBooks(List<ConfirmationRequestDto> confirmationRequestDtoList,Long userId);

}
