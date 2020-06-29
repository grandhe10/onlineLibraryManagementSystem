package com.demo.onlinebookborrowsystem.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.onlinebookborrowsystem.dto.CategoryListResponseDto;
import com.demo.onlinebookborrowsystem.service.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    private static Log logger = LogFactory.getLog(CategoryController.class);
    
    /**
     * This method is used to get all the books  by categoryName
     * @param categoryName
     * @return author name and book title by categoryName
     */
    @GetMapping("/books")
    public ResponseEntity<CategoryListResponseDto> getBooksByCategoryName(@RequestParam("categoryName") String categoryName)
    {
        logger.info("Inside getBooksByCategoryName Category controller ");
        return new ResponseEntity<>(categoryService.getBooksByCategoryName(categoryName),HttpStatus.OK);
    }
}