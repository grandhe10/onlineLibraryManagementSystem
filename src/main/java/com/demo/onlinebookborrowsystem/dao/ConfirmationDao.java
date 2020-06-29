package com.demo.onlinebookborrowsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinebookborrowsystem.model.Confirmation;
@Repository
public interface ConfirmationDao extends CrudRepository<Confirmation, Long>{

}
