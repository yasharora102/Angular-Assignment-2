package com.yasharora102.test.sar.endpoint.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.yasharora102.test.sar.dto.ResponseData;
import com.yasharora102.test.sar.endpoint.IDashboardEndPoint;
import com.yasharora102.test.sar.exception.EndPointException;

import java.security.Principal;

/**
 * Created on 5/9/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class DashboardEndPointException implements IDashboardEndPoint {
    @Override
    public ResponseEntity display(Principal p_Principal) throws EndPointException {
        return ResponseEntity.ok(new ResponseData("200", p_Principal.getName()));
    }
}
