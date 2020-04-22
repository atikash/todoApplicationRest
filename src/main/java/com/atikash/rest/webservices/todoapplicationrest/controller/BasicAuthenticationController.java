package com.atikash.rest.webservices.todoapplicationrest.controller;

import com.atikash.rest.webservices.todoapplicationrest.bean.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BasicAuthenticationController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean AuthenticationBean() {
        return new AuthenticationBean("You are authenticated");
    }

}
