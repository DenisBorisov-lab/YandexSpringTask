package com.example.yandex.models.dto;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class EditQuizDto {
    private UUID id;
    private String name;
    private List<QuestionDto> questions;
}
