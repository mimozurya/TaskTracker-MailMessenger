package com.task.tracker.dto.email;

public record EmailMessageDto(
        String email,
        String title,
        String body
) {
}
