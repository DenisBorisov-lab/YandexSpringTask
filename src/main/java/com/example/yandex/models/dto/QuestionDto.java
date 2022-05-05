package com.example.yandex.models.dto;

import com.example.yandex.models.Type;
import lombok.Getter;

@Getter
public class QuestionDto<T> {
    private String message;
    private T correctAnswer;
    private Type type;
}
