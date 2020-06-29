package com.demo.onlinebookborrowsystem.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinebookborrowsystem.model.Category;
/**
 * @author Haritha
 *
 */
@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {
    
    /**
     * This method is used to get Category details by categoryName
     * @param categoryName
     * @return Category
     */
    Optional<Category> findByCategoryName(String categoryName);

	/**
	 * This method is used to get Category by categoryId
	 * @param categoryId
	 * @return Category
	 */
	Optional<Category> findByCategoryId(Long categoryId);
}