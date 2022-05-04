package com.example.yandex.models.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class DeleteQuestionDto {
    private UUID quizId;
    private UUID id;
}
