package com.demo.onlinebookborrowsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinebookborrowsystem.model.Books;
@Repository
public interface BookDao extends CrudRepository<Books, Long>{

	Optional<List<Books>> findByAuthorNameContainsAndBookTitleContains(String authorName, String bookTitle);

	Optional<Books> findByAuthorNameAndBookTitle(String authorName, String bookTitle);

	Optional<Books> findByBookId(Long bookId);

}
