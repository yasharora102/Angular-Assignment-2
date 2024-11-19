package com.yasharora102.test.sar.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yasharora102.test.sar.exception.EndPointException;

import static com.yasharora102.test.sar.statval.ISarConstant.Path.DASHBOARD;

import java.security.Principal;

/**
 * Created on 5/9/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RequestMapping(DASHBOARD)
public interface IDashboardEndPoint {

    ResponseEntity display(Principal p_Principal) throws EndPointException;
}
