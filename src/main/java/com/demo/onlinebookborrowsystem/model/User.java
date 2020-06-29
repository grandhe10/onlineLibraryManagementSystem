package com.demo.onlinebookborrowsystem.model;

import javax.persistence.Entity;
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
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	Long userId;
	String userName;
	String password;

}
