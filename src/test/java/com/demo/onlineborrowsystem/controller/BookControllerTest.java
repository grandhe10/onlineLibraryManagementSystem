package com.demo.onlineborrowsystem.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.demo.onlinebookborrowsystem.dto.BookListResponseDto;
import com.demo.onlinebookborrowsystem.dto.BookRequestDto;
import com.demo.onlinebookborrowsystem.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.ArgumentMatchers.any;
@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

	@Mock
    BookService bookService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    BookController bookController;

    BookRequestDto bookRequestDto;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
        
        
    }

    	@Test
        public void getBooksByAuthorNameAndBookTitleTest() throws Exception
        {
    		BookRequestDto bookRequestDto = new BookRequestDto();
            bookRequestDto.setAuthorName("ABCD");
            bookRequestDto.setBookTitle("book1");
            
            BookListResponseDto bookListResponseDto=new BookListResponseDto();
            bookListResponseDto.setMesaage("Please find the list of available books");
            bookListResponseDto.setStatusCode(200);
            
            //given
            when(bookService.getBooksByAuthorNameAndBookTitle(any(BookRequestDto.class))).thenReturn(bookListResponseDto);
            
            mockMvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(objectMapper.writeValueAsString(bookRequestDto)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
    
            verify(bookService).getBooksByAuthorNameAndBookTitle(any(BookRequestDto.class));
        }

        
    }