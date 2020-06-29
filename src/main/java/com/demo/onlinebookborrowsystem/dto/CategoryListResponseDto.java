package com.demo.onlinebookborrowsystem.dto;

import java.util.List;

public class CategoryListResponseDto {
	List<CategoryResponseDto> categoryResponseDtoList;
	String message;
	Integer statusCode;

	public List<CategoryResponseDto> getCategoryResponseDtoList() {
		return categoryResponseDtoList;
	}

	public void setCategoryResponseDtoList(List<CategoryResponseDto> categoryResponseDtoList) {
		this.categoryResponseDtoList = categoryResponseDtoList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}