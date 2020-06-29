package com.demo.onlinebookborrowsystem.service;

import javax.validation.Valid;

import com.demo.onlinebookborrowsystem.dto.LoginDto;
import com.demo.onlinebookborrowsystem.dto.LoginResponseDto;

/**
 * @author Suma
 *
 */
public interface UserService {
    /**
     * This method is used for user Login
     * @param loginDto
     * @return LoginResponseDto
     */
   public  LoginResponseDto loginUser(@Valid LoginDto loginDto);

 

}