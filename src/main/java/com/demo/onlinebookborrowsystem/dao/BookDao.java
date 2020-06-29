package com.demo.onlinebookborrowsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinebookborrowsystem.model.Books;
@Repository
public interface BookDao extends CrudRepository<Books, Long>{

}
