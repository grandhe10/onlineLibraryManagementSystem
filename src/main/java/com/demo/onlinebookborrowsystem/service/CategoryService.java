package com.demo.onlinebookborrowsystem.service;

import com.demo.onlinebookborrowsystem.dto.CategoryListResponseDto;

public interface CategoryService {

	/**
	 * This method is used to get books by categoryName
	 * @param eq
	 * @return CategoryListResponseDto
	 */
	CategoryListResponseDto getBooksByCategoryName(String eq);

}
