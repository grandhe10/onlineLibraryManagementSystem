package com.demo.onlinebookborrowsystem.dto;

import java.util.List;

public class BorrowDto {
	List<BorrowListDto> borrowListDto;

	public List<BorrowListDto> getBorrowListDto() {
		return borrowListDto;
	}

	public void setBorrowListDto(List<BorrowListDto> borrowListDto) {
		this.borrowListDto = borrowListDto;
	}

}