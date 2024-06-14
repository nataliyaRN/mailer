package org.wierts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.wierts.dto.Message;

import java.util.Properties;

@Service
public class MessageService {

    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(Message message){
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        mainMessage.setTo("nataliya.wierts@gmail.com");
        mainMessage.setSubject("homepage kontakt");
        mainMessage.setText(message.getEmail()+" "+message.getMessage());

        mailSender.send(mainMessage);
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("nataliya.wierts@gmail.com");
        mailSender.setPassword("");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
