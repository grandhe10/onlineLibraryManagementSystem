package com.demo.onlinebookborrowsystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.onlinebookborrowsystem.dao.BookDao;
import com.demo.onlinebookborrowsystem.dao.CategoryDao;
import com.demo.onlinebookborrowsystem.dto.CategoryListResponseDto;
import com.demo.onlinebookborrowsystem.dto.CategoryResponseDto;
import com.demo.onlinebookborrowsystem.model.Books;
import com.demo.onlinebookborrowsystem.model.Category;
import com.demo.onlinebookborrowsystem.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	BookDao bookDao;
	static Log logger = LogFactory.getLog(CategoryServiceImpl.class);

	/**
	 * This method is used to get list of author names and books title by category
	 * name
	 * 
	 * @{inherit Doc}
	 */
	@Override
	public CategoryListResponseDto getBooksByCategoryName(String categoryName) {
		logger.info("Inside getBooksByCategoryName Category service Impl ");
		CategoryListResponseDto categoryListResponseDto = new CategoryListResponseDto();

		Optional<Category> categoryOptional = categoryDao.findByCategoryName(categoryName);
		if (!categoryOptional.isPresent()) {
			categoryListResponseDto.setMessage("No books avaliable matching the category name");
			categoryListResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
			return categoryListResponseDto;
		}
		Optional<List<Books>> bookListOptional = bookDao.findByCategoryId(categoryOptional.get().getCategoryId());
		if (!bookListOptional.isPresent()) {
			categoryListResponseDto.setMessage("No books avaliable matching the category name");
			categoryListResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
			return categoryListResponseDto;
		}

		List<CategoryResponseDto> categoryList = bookListOptional.get().stream()
				.map(books -> getCategoryResponseDto(books)).collect(Collectors.toList());
		categoryListResponseDto.setCategoryResponseDtoList(categoryList);
		categoryListResponseDto.setMessage("please find the list of available books");
		categoryListResponseDto.setStatusCode(HttpStatus.OK.value());
		return categoryListResponseDto;
	}

	private CategoryResponseDto getCategoryResponseDto(Books books) {
		logger.info("Inside getCategoryResponseDto Category service impl ");
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();

		categoryResponseDto.setAuthorName(books.getAuthorName());
		categoryResponseDto.setBookTitle(books.getBookTitle());

		return categoryResponseDto;
	}
}