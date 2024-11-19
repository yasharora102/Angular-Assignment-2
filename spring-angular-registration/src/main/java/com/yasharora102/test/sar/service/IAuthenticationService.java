package com.yasharora102.test.sar.service;

import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.yasharora102.test.sar.exception.ServiceException;
import com.yasharora102.test.sar.model.User;

import javax.servlet.http.HttpServletResponse;

/**
 * Created on 5/17/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAuthenticationService extends LogoutHandler {

    User login(String p_UserName) throws ServiceException;

    void updateStatusLoggedIn(User p_User) throws ServiceException;

    void updateStatusLoggedOut(String p_UserName) throws ServiceException;

    void logoutJwt(HttpServletResponse httpServletResponse, String p_CookieName) throws ServiceException;
}
