package com.demo.onlinebookborrowsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinebookborrowsystem.model.Books;
/**
 * @author Suma
 *
 */
@Repository
public interface BookDao extends CrudRepository<Books, Long>{

	/**
	 * This method is used to get list of books by authorName and bookTitle
	 * @param authorName
	 * @param bookTitle
	 * @return List<Books>
	 */
	Optional<List<Books>> findByAuthorNameContainsAndBookTitleContains(String authorName, String bookTitle);

	/**
	 * This method is used to get the book by authorName and bookTitle
	 * @param authorName
	 * @param bookTitle
	 * @return Book
	 */
	Optional<Books> findByAuthorNameAndBookTitle(String authorName, String bookTitle);

	/**
	 * This method is used to get the book details by bookId
	 * @param bookId
	 * @return Book
	 */
	Optional<Books> findByBookId(Long bookId);

	/**
	 * This method is used to get the list of books by categoryId
	 * @param categoryId
	 * @return List<Books>
	 */
	Optional<List<Books>> findByCategoryId(Long categoryId);

}
