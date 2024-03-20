package edu.miu.cs.cs544.security;

import org.springframework.mail.javamail.JavaMailSender;
import jakarta.jms.ConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableJms
public class JMSConfig {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;
    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private boolean smtpAuth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private boolean starttlsEnabled;
//
//    @Value("${spring.mail.properties.mail.smtp.starttls.required}")
//    private boolean starttlsRequired;

//    @Value("${spring.mail.properties.mail.smtp.timeout}")
//    private int timeout;

//    @Value("${spring.mail.properties.mail.smtp.connectiontimeout}")
//    private int connectionTimeout;

//    @Value("${spring.mail.properties.mail.debug}")
//    private boolean debug;

    @Bean
    public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory connectionFactory,
                                                     DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setMessageConverter(jacksonJmsMessageConverter());
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_asb_");
        return converter;
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", String.valueOf(smtpAuth));
        mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", String.valueOf(starttlsEnabled));
//        mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.required", String.valueOf(starttlsRequired));
//        mailSender.getJavaMailProperties().setProperty("mail.smtp.timeout", String.valueOf(timeout));
//        mailSender.getJavaMailProperties().setProperty("mail.smtp.connection timeout", String.valueOf(connectionTimeout));
//        mailSender.getJavaMailProperties().setProperty("mail.debug", String.valueOf(debug));

        return mailSender;
    }

}
