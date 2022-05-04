package com.example.yandex.models.dto;

import lombok.Getter;

@Getter
public class QuestionDto<T> {
    private String message;
    private T correctAnswer;
}