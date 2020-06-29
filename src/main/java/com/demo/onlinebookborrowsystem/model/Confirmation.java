package com.demo.onlinebookborrowsystem.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Data
public class Confirmation {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	Long confrimationId;
	Long userId;
	Long bookId;
	LocalDate fromDate;
	LocalDate toDate;
	@Enumerated(EnumType.STRING)
	BookStatus status;
	public Long getConfrimationId() {
		return confrimationId;
	}
	public void setConfrimationId(Long confrimationId) {
		this.confrimationId = confrimationId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public BookStatus getStatus() {
		return status;
	}
	public void setStatus(BookStatus status) {
		this.status = status;
	}
}
