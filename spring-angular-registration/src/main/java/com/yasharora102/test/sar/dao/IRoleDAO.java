package com.yasharora102.test.sar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasharora102.test.sar.exception.DAOException;
import com.yasharora102.test.sar.model.Role;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IRoleDAO extends JpaRepository<Role, Long> {

    Role findByName(String p_Name) throws DAOException;

    Role findByCode(String p_Code) throws DAOException;
}
