package com.mgl.chr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;


@Configuration
public class EmailConfig {

    @Value("${chr.notification.email.from}")
    private String fromEmail;

    @Bean
    public SimpleMailMessage emailTemplate() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("touser@gmail.com");
        message.setFrom(fromEmail);
        message.setSubject("Notify Hospital/Subscriber");
        message.setText("You have successfully subscribed to CHR !!");
        return message;
    }
}
