package com.demo.onlinebookborrowsystem.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinebookborrowsystem.model.Confirmation;
@Repository
public interface ConfirmationDao extends CrudRepository<Confirmation, Long>{

	Optional<Confirmation> findByUserIdAndBookIdAndFromDate(Long userId, Long bookId, LocalDate fromDate);

	 Optional<List<Confirmation>> findAllByUserId(Long userId);

	
}
