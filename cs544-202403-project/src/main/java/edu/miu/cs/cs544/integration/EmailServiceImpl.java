package edu.miu.cs.cs544.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//@Service
//public class EmailServiceImpl implements EmailService {
//
//    @Autowired
//    JmsTemplate jmsTemplate;
//    @Override
//    @Async
//    public void sendEmail(String to, String subject, String body) {
//        Email email = new Email(to, subject, body);
//        jmsTemplate.convertAndSend("email.queue", email);
//    }
//}
