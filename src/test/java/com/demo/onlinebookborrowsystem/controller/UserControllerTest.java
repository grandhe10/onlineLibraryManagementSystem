package com.demo.onlinebookborrowsystem.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedHashMap;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.onlinebookborrowsystem.dto.LoginDto;
import com.demo.onlinebookborrowsystem.dto.LoginResponseDto;
import com.demo.onlinebookborrowsystem.service.ConfirmationService;
import com.demo.onlinebookborrowsystem.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    UserService userservice;
    MockMvc mockMvc;
    ObjectMapper objectMapper;

    @Mock
    ConfirmationService confirmationService;
   @InjectMocks
    UserController usercontroller;
   
   @InjectMocks
   ConfirmationController confirmationController;
    LoginDto loginDto;
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(usercontroller).build();
        
        loginDto = new LoginDto();
        loginDto.setPassword("reddy");
        loginDto.setUserName("lahari");
    }
        @Test
        public void loginEmployee() throws Exception
        {
            LoginResponseDto loginResponseDto=new LoginResponseDto();
            loginResponseDto.setMessage("Employee logged in");
            loginResponseDto.setStatusCode(200);
            //given
            when(userservice.loginUser(any(LoginDto.class))).thenReturn(loginResponseDto);
            
            mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(objectMapper.writeValueAsString(loginDto)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
    
            verify(userservice).loginUser(any(LoginDto.class));
        }
        
       

}