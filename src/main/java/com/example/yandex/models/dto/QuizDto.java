package com.example.yandex.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
public class QuizDto {
    private String name;
    private List<QuestionDto> questionDtos;
    private LocalDateTime start;
    private LocalDateTime end;
}
