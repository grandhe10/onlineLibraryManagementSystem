package com.demo.onlinebookborrowsystem.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinebookborrowsystem.model.Confirmation;
/**
 * @author Suma,Lahari
 *
 */
@Repository
public interface ConfirmationDao extends CrudRepository<Confirmation, Long>{

	/**
	 * This method is used to get Confirmation by userId,BookId and fromDate
	 * @param userId
	 * @param bookId
	 * @param fromDate
	 * @return Confirmation
	 */
	Optional<Confirmation> findByUserIdAndBookIdAndFromDate(Long userId, Long bookId, LocalDate fromDate);

	 /**
	  * This method is used to get list of books borrowed by userId
	 * @param userId
	 * @return List<Confirmation>
	 */
	Optional<List<Confirmation>> findAllByUserId(Long userId);

	
}
