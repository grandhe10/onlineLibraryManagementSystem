package com.demo.onlinebookborrowsystem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.onlinebookborrowsystem.controller.BookController;
import com.demo.onlinebookborrowsystem.controller.CategoryController;
import com.demo.onlinebookborrowsystem.controller.ConfirmationController;
import com.demo.onlinebookborrowsystem.controller.UserController;

@SpringBootTest
class OnlineBookBorrrowSystemApplicationTests {

	@Autowired
	BookController bookController;
	@Autowired
	UserController userController;
	@Autowired
	ConfirmationController confirmationController;

	@Autowired
	CategoryController categoryController;

	@Test
	public void contexLoads() throws Exception {
		assertThat(bookController).isNotNull();
	}

	@Test
	public void contexLoads1() throws Exception {
		assertThat(userController).isNotNull();
	}

	@Test
	public void contexLoads2() throws Exception {
		assertThat(confirmationController).isNotNull();
	}
	
	@Test
	public void contexLoads3() throws Exception {
		assertThat(categoryController).isNotNull();
	}
	
}
