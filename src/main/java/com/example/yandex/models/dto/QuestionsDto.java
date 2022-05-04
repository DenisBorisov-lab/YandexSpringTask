package com.example.yandex.models.dto;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class QuestionsDto {
    private UUID quizId;
    private List<QuestionDto> questions;
}
