package com.demo.onlinebookborrowsystem.dao;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.demo.onlinebookborrowsystem.model.User;
@Repository
public interface UserDao extends CrudRepository<User, Long> {
    static Log logger = LogFactory.getLog(UserDao.class);
    /**this method validate user login
     * @param employeeName
     * @param password
     * @return logged in successfully
     */
    public Optional<User> findByUserNameAndPassword( String userName,String password);
    
	public Optional<User> findByUserId(Long userId);

 

}