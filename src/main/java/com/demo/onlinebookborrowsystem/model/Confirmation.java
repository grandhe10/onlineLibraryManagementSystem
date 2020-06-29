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
}
