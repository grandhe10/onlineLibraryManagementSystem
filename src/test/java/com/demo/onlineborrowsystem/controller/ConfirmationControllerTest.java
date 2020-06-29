package com.demo.onlineborrowsystem.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.LinkedHashMap;

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

import com.demo.onlinebookborrowsystem.controller.BookController;
import com.demo.onlinebookborrowsystem.controller.ConfirmationController;
import com.demo.onlinebookborrowsystem.dto.BookListResponseDto;
import com.demo.onlinebookborrowsystem.dto.BookRequestDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationRequestDto;
import com.demo.onlinebookborrowsystem.dto.ConfirmationResponseDto;
import com.demo.onlinebookborrowsystem.service.BookService;
import com.demo.onlinebookborrowsystem.service.ConfirmationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
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
        public void bookBorrowTest() throws Exception
        {
    		
            ConfirmationResponseDto confirmationResponseDto = new ConfirmationResponseDto();
    		confirmationResponseDto.setMessage("Borrow request is successfully submitted");
    		confirmationResponseDto.setStatusCode(202);
    		List<ConfirmationRequestDto> confirmationRequestDtoList = new ArrayList<>();
    		ConfirmationRequestDto confirmationRequestDto = new ConfirmationRequestDto();
    		confirmationRequestDto.setBookId(1L);
    		confirmationRequestDto.setFromDate("2020-07-01");
    		confirmationRequestDto.setToDate("2020-07-04");
    		confirmationRequestDtoList.add(confirmationRequestDto);
            //given
            when(confirmationService.borrowBooks(any(List.class), eq(1L))).thenReturn(confirmationResponseDto);
            
            mockMvc.perform(post("/users/{userId}/confirmations",1L).contentType(MediaType.APPLICATION_JSON_VALUE)
        			.content(objectMapper.writeValueAsString(confirmationRequestDtoList)))
        				.andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
        		verify(confirmationService).borrowBooks(any(List.class), eq(1L));
        }

        
    }