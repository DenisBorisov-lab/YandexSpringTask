package com.example.yandex.models.dto;

import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
public class RunQuizDto<T> {
    private Long id;
    private UUID quizId;
    private Map<UUID, T> answers;
}
