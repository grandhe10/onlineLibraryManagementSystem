package com.demo.onlinebookborrowsystem.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.demo.onlinebookborrowsystem.dto.BorrowListDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationRequestDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationResponseDto;
import com.demo.onlinebookborrowsystem.service.ConfirmationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class ConfirmationControllerTest {

	@Mock
	ConfirmationService confirmationService;

	MockMvc mockMvc;
	ObjectMapper objectMapper;

	@InjectMocks
	ConfirmationController confirmationController;

	ConfirmationRequestDto bookRequestDto;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();

		mockMvc = MockMvcBuilders.standaloneSetup(confirmationController).build();

	}

	@SuppressWarnings("unchecked")
	@Test
	public void bookBorrowTest() throws Exception {

		ConfirmationResponseDto confirmationResponseDto = new ConfirmationResponseDto();
		confirmationResponseDto.setMessage("Borrow request is successfully submitted");
		confirmationResponseDto.setStatusCode(202);
		List<ConfirmationRequestDto> confirmationRequestDtoList = new ArrayList<>();
		ConfirmationRequestDto confirmationRequestDto = new ConfirmationRequestDto();
		confirmationRequestDto.setBookId(1L);
		confirmationRequestDto.setFromDate("2020-07-01");
		confirmationRequestDto.setToDate("2020-07-04");
		confirmationRequestDtoList.add(confirmationRequestDto);
		// given
		when(confirmationService.borrowBooks(any(List.class), eq(1L))).thenReturn(confirmationResponseDto);

		mockMvc.perform(post("/users/{userId}/confirmations", 1L).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(confirmationRequestDtoList))).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
		verify(confirmationService).borrowBooks(any(List.class), eq(1L));
	}

	@Test
	public void getbookdetailsbyuserId() throws Exception {
		BorrowListDto borrowlistDto = new BorrowListDto();

		borrowlistDto.setAuthorName("gyu");
		borrowlistDto.setBookTitle("gs");
		borrowlistDto.setFromDate(LocalDate.parse("2020-06-29"));
		borrowlistDto.setToDate(LocalDate.parse("2020-06-30"));
		List<BorrowListDto> borrowdtolist = new ArrayList<>();
		borrowdtolist.add(borrowlistDto);
	
		when(confirmationService.getBorrowlistByUserId(eq(1L))).thenReturn(borrowdtolist);
		mockMvc.perform(get("/users/{userId}", 1L).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0]", Matchers.any(LinkedHashMap.class)));

		verify(confirmationService).getBorrowlistByUserId(eq(1L));
	}

}