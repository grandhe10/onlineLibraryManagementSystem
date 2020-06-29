package com.demo.onlinebookborrowsystem.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinebookborrowsystem.model.Category;
@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {
    
    /**
     * @param categoryName
     * @return list of book titles and author names by category name
     */
    Optional<Category> findByCategoryName(String categoryName);

	Optional<Category> findByCategoryId(Long categoryId);
}