package com.demo.onlinebookborrowsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinebookborrowsystem.model.Category;
@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {

}
