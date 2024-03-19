package edu.miu.cs.cs544.integration;


public interface EmailService {
    void sendEmail (String to, String subject, String body);
}
