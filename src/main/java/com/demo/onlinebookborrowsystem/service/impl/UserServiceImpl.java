package com.demo.onlinebookborrowsystem.service.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.onlinebookborrowsystem.dao.UserDao;
import com.demo.onlinebookborrowsystem.dto.LoginDto;
import com.demo.onlinebookborrowsystem.dto.LoginResponseDto;
import com.demo.onlinebookborrowsystem.model.User;
import com.demo.onlinebookborrowsystem.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    private static Log logger = LogFactory.getLog(UserServiceImpl.class);
    @Autowired
    UserDao userDao;

    @Override
    public LoginResponseDto loginUser(@Valid LoginDto loginDto) {
        logger.info("Inside loginUser method of UserServiceImpl");
         LoginResponseDto loginResponseDto = new LoginResponseDto();
            Optional<User> employee = userDao.findByUserNameAndPassword(loginDto.getUserName(),
                    loginDto.getPassword());
            if (employee.isPresent()) {
                logger.info("user logged in successfully");
                loginResponseDto.setMessage("User logged in Successfully");
                loginResponseDto.setStatusCode(HttpStatus.OK.value());
                
                return loginResponseDto;
            }  
            loginResponseDto.setMessage("Invalid credentials!!!");
            loginResponseDto.setStatusCode(HttpStatus.UNAUTHORIZED.value());
            return loginResponseDto;

        }
}
