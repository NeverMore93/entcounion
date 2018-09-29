package com.microfocus.entcounion.bean;

import com.microfocus.entcounion.exceptions.EmailSendFailedException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j(topic = "Email")
public class EmailBean {

    @Bean(name="unionEmail")
    public Email email(){
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("y1305882275@gmail.com", "q19938111949"));
        email.setSSLOnConnect(true);
        try {
            email.setFrom("y1305882275@gmail.com");
        } catch (EmailException e) {
            log.error(e.toString());
            throw new EmailSendFailedException(e);
        }
        return email;
    }
}
