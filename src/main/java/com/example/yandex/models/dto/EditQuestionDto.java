package com.example.yandex.models.dto;

import com.example.yandex.models.Type;
import lombok.Getter;

import java.util.UUID;

@Getter
public class EditQuestionDto <T> {
    private UUID quizId;
    private UUID id;
    private String message;
    private T correctAnswer;
    private Type type;
}
