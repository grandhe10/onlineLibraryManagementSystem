package com.demo.onlinebookborrowsystem.service;

import javax.validation.Valid;

import com.demo.onlinebookborrowsystem.dto.LoginDto;
import com.demo.onlinebookborrowsystem.dto.LoginResponseDto;

public interface UserService {
    /**
     * @param loginDto
     * @return employee logged in
     */
   public  LoginResponseDto loginUser(@Valid LoginDto loginDto);

 

}