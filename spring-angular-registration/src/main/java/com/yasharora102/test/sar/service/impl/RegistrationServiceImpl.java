package com.yasharora102.test.sar.service.impl;

import static com.yasharora102.test.sar.statval.ISarConstant.Path.REGISTER;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.yasharora102.test.sar.dao.IUserDAO;
import com.yasharora102.test.sar.dto.RequestRegistrationDTO;
import com.yasharora102.test.sar.dto.ResponseData;
import com.yasharora102.test.sar.dto.ResponseValidationDTO;
import com.yasharora102.test.sar.mapper.UserMapper;
import com.yasharora102.test.sar.service.IRegistrationService;
import com.yasharora102.test.sar.statval.ISarConstant;
import com.yasharora102.test.sar.statval.ISarConstant.Bean;
import com.yasharora102.test.sar.util.APIErrorBuilder;
import com.yasharora102.test.sar.validation.IRequestValidator;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class RegistrationServiceImpl implements IRegistrationService {

    @Autowired private IUserDAO userDAO;
    @Autowired private UserMapper userMapper;
    @Autowired @Qualifier(Bean.REGISTRATION_VALIDATOR) private IRequestValidator<RequestRegistrationDTO> registrationValidator;
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public ResponseEntity register(RequestRegistrationDTO p_Request) throws ServiceException {
        ResponseEntity response;
        ResponseValidationDTO responseValidation = registrationValidator.validate(p_Request);
        if (responseValidation.getIsValid()) {
            userDAO.save(userMapper.convert(p_Request));
            response = ResponseEntity.ok(new ResponseData("200", "Success Register User"));
        }else {
            LOGGER.error("Request is not Valid {}", responseValidation.getMessage());
            response = new ResponseEntity<>(APIErrorBuilder.badRequest(RegistrationServiceImpl.class, responseValidation.getMessage(), ISarConstant.Path.REGISTRATION.concat(REGISTER)), HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
