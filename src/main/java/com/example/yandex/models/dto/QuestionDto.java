package com.example.yandex.models.dto;

import com.example.yandex.models.Type;
import lombok.Data;

@Data
public class QuestionDto {
    private final String message;
    private final Type type;
}
