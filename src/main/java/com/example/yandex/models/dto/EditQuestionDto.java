package com.example.yandex.models.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class EditQuestionDto <T> {
    private UUID quizId;
    private UUID id;
    private String message;
    private T correctAnswer;
}
