package com.demo.onlinebookborrowsystem.dto;

import java.util.List;

public class BookListResponseDto {
	
	List<BookResponseDto> bookResponseDtoList;
	String mesaage;
	Integer statusCode;
	public List<BookResponseDto> getBookResponseDtoList() {
		return bookResponseDtoList;
	}
	public void setBookResponseDtoList(List<BookResponseDto> bookResponseDtoList) {
		this.bookResponseDtoList = bookResponseDtoList;
	}
	public String getMesaage() {
		return mesaage;
	}
	public void setMesaage(String mesaage) {
		this.mesaage = mesaage;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
