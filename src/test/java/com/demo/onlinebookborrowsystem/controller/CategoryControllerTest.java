package com.demo.onlinebookborrowsystem.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.demo.onlinebookborrowsystem.dto.CategoryListResponseDto;
import com.demo.onlinebookborrowsystem.dto.CategoryResponseDto;
import com.demo.onlinebookborrowsystem.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

	@Mock
    CategoryService categoryService;
    MockMvc mockMvc;
    ObjectMapper objectMapper;
    @InjectMocks
    CategoryController categoryController;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();

    }
    @Test
    public void getBooksByCategoryName() throws Exception

    {
        CategoryListResponseDto categoryListResponseDto=new CategoryListResponseDto();
        
        CategoryResponseDto categoryResponseDto=new  CategoryResponseDto ();
        categoryResponseDto.setAuthorName("kevin");
        categoryResponseDto.setBookTitle("abc");
        List<CategoryResponseDto> categoryResponseDtoList=new ArrayList<>();
        categoryResponseDtoList.add(categoryResponseDto);
        categoryListResponseDto.setCategoryResponseDtoList(categoryResponseDtoList);
        categoryListResponseDto.setMessage("please find the available books");
        categoryListResponseDto.setStatusCode(200);
        when(categoryService.getBooksByCategoryName(eq("suspense"))).thenReturn(categoryListResponseDto);
        
        mockMvc.perform(get("/books")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .param("categoryName","suspense") 
        .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk()) 
        .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
        verify(categoryService).getBooksByCategoryName(eq("suspense"));
    }
}