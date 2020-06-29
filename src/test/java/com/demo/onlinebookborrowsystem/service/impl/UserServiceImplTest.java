package com.demo.onlinebookborrowsystem.service.impl;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.onlinebookborrowsystem.dao.UserDao;
import com.demo.onlinebookborrowsystem.dto.LoginDto;
import com.demo.onlinebookborrowsystem.dto.LoginResponseDto;
import com.demo.onlinebookborrowsystem.model.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    User user;
    LoginResponseDto loginResponseDto;

    @Mock
    UserDao userDao;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    LoginDto loginDto;
    @BeforeEach
    public void setUp() {
    	loginResponseDto = new LoginResponseDto();
        loginResponseDto.setMessage("Employee logged in");
        loginResponseDto.setStatusCode(200);
    }

    @Test
    public void loginEmployeeTest() {
        
        User user = new User();
        user.setUserId(1L);
        user.setUserName("sai");
        
        user.setPassword("1234");
        
        LoginDto loginDto = new LoginDto();
        loginDto.setUserName("sai");
        loginDto.setPassword("1234");
        
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setMessage("Employee logged in");
        loginResponseDto.setStatusCode(200);
        when(userDao.findByUserNameAndPassword("sai","1234")).thenReturn(Optional.of(user));
        userServiceImpl.loginUser(loginDto);
        verify(userDao).findByUserNameAndPassword("sai", "1234");
    }

}