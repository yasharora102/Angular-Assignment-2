package com.yasharora102.test.sar.endpoint.impl;

import static com.yasharora102.test.sar.statval.ISarConstant.Path.REGISTER;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasharora102.test.sar.dto.RequestRegistrationDTO;
import com.yasharora102.test.sar.endpoint.IRegistrationEndPoint;
import com.yasharora102.test.sar.exception.EndPointException;
import com.yasharora102.test.sar.exception.ServiceException;
import com.yasharora102.test.sar.service.IRegistrationService;
import com.yasharora102.test.sar.statval.ISarConstant;
import com.yasharora102.test.sar.util.APIErrorBuilder;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping(ISarConstant.Path.REGISTRATION)
public class RegistrationEndPointImpl implements IRegistrationEndPoint {

    @Autowired private IRegistrationService registrationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationEndPointImpl.class);

    @PostMapping(ISarConstant.Path.REGISTER)
    @Override
    public ResponseEntity register(@RequestBody RequestRegistrationDTO p_Request) throws EndPointException {
        try {
            return registrationService.register(p_Request);
        } catch (ServiceException e) {
            LOGGER.error("Error conduct register : {}", e.toString());
            return new ResponseEntity<>(APIErrorBuilder.internalServerError(RegistrationEndPointImpl.class, "Error Register Process : "+e.getMessage(), ISarConstant.Path.REGISTRATION.concat(REGISTER)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
