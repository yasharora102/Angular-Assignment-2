package com.yasharora102.test.sar.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.yasharora102.test.sar.dto.RequestRegistrationDTO;
import com.yasharora102.test.sar.exception.EndPointException;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IRegistrationEndPoint {

    ResponseEntity register(@RequestBody RequestRegistrationDTO p_Request) throws EndPointException;
}
