package com.ent.user.portalservices.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ent.user.portalservices.model.User;
import com.ent.user.portalservices.utils.UserLoginConstants;

@RestController
public class UserLoginController {
	
	private static final String userName="raj";
	private static final String passWord="rajeev";

	@PostMapping(value = "/user/login")
    public ResponseEntity<Object> validateUser(@RequestBody User user) {
        if (user!=null) {
           if(!StringUtils.isEmpty(user.getUserName()) &&  !StringUtils.isEmpty(user.getPassword()))
		   {
			if(user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equalsIgnoreCase(passWord))
			{
				return new ResponseEntity<Object>(UserLoginConstants.LOGIN_SUCCESS, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<Object>(UserLoginConstants.LOGIN_FAIL, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
			}
		  }
        }
		return new ResponseEntity<Object>(UserLoginConstants.BAD_REQUEST, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}