package com.yasharora102.test.sar.service;

import org.springframework.http.ResponseEntity;

import com.yasharora102.test.sar.dto.RequestRegistrationDTO;
import com.yasharora102.test.sar.exception.ServiceException;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IRegistrationService {

    ResponseEntity register(RequestRegistrationDTO p_Request) throws ServiceException;
}
