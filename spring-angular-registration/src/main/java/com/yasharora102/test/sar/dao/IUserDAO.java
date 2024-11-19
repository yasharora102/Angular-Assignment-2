package com.yasharora102.test.sar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasharora102.test.sar.exception.DAOException;
import com.yasharora102.test.sar.model.User;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IUserDAO extends JpaRepository<User, Long> {

    User findByMobileNumber(String p_MobileNumber) throws DAOException;

    User findByEmail(String p_Email) throws DAOException;

    User findByCodeAndStatus(String p_Code, Boolean p_Status)throws DAOException;

    User findByCodeOrEmail(String p_Code, String p_Email) throws DAOException;
}
