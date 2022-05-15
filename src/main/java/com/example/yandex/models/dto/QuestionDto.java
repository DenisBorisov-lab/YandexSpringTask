package com.example.yandex.models.dto;

import com.example.yandex.models.Type;
import lombok.Getter;

@Getter
public class QuestionDto {
    private String message;
    private String correctAnswer;
    private Type type;
}
