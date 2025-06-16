package com.task.tracker.service;

import com.task.tracker.config.properties.EmailConfigurationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailSenderService {

    private final JavaMailSender mailSender;
    private final EmailConfigurationProperties emailProperties;

    public void sendEmail(String toEmail, String subject, String body) {
        log.info("Sending email to {}", toEmail);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailProperties.getUsername());
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        log.info("Email sent successfully to {}", toEmail);
    }
}
