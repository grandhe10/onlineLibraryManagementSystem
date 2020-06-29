package com.demo.onlinebookborrowsystem.service.impl;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.onlinebookborrowsystem.dao.BookDao;
import com.demo.onlinebookborrowsystem.dao.CategoryDao;
import com.demo.onlinebookborrowsystem.dto.CategoryResponseDto;
@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    BookDao bookDao;

    @InjectMocks
    CategoryServiceImpl categoryServiceImpl;
    @Mock
    CategoryDao categoryDao;

    @BeforeEach
    public void setUp() { 

    }


    @Test
    public void getBooksByCategoryName() {
        CategoryResponseDto responseDto = new CategoryResponseDto();
        responseDto.setAuthorName("kevin");
        responseDto.setBookTitle("abc");
        categoryServiceImpl.getBooksByCategoryName("suspense");
        verify(categoryDao).findByCategoryName("suspense");
    }
}