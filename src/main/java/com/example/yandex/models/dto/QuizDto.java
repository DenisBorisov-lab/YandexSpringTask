package com.example.yandex.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
public class QuizDto {
    private String name;
    private List<QuestionDto> questionDtos;
    private LocalDateTime start;
    private LocalDateTime end;
}
