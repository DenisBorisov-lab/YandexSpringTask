package com.example.yandex.models.dto;

import com.example.yandex.models.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class QuestionDto {
    private String message;
    private Type type;
}
