package com.demo.onlinebookborrowsystem.service;

import com.demo.onlinebookborrowsystem.dto.CategoryListResponseDto;

public interface CategoryService {

	CategoryListResponseDto getBooksByCategoryName(String eq);

}
