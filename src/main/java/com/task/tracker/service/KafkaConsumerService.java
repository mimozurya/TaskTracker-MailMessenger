package com.task.tracker.service;

import com.task.tracker.dto.email.EmailMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    private final EmailSenderService emailSenderService;
    private final String TOPIC = "EMAIL_SENDING_TASKS";

    @KafkaListener(topics = TOPIC, groupId = "group_id")
    public void consume(EmailMessageDto emailMessage) {
        log.info("A message has arrived for the mail {}", emailMessage.email());

        emailSenderService.sendEmail(
                emailMessage.email(),
                emailMessage.title(),
                emailMessage.body()
        );
    }
}
