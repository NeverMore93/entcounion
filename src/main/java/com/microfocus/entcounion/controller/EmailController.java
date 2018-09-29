package com.microfocus.entcounion.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/email")
public class EmailController {

    @Resource(name = "unionEmail")
    private Email email;

    @ResponseStatus(code=HttpStatus.CREATED)
    @PutMapping(value = "/test")
    public void test(){
        email.setSubject("Test");
        try {
            email.setMsg("Test");
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }

}
