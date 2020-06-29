package com.demo.onlinebookborrowsystem.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinebookborrowsystem.model.User;
/**
 * @author Lahari
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {
   
    /**This method validate user login
     * @param employeeName
     * @param password
     * @return User
     */
    public Optional<User> findByUserNameAndPassword( String userName,String password);
    
	/**
	 * This method is used to get User by userId
	 * @param userId
	 * @return User
	 */
	public Optional<User> findByUserId(Long userId);

 

}