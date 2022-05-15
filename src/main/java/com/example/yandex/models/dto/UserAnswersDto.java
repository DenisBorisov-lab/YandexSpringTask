package com.example.yandex.models.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
public class UserAnswersDto {
    private Long id;
    private UUID quizId;
    private Map<UUID, String> answers;
    private LocalDateTime start;
    private LocalDateTime end;
}
