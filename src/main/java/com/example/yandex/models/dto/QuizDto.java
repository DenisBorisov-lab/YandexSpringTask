package com.example.yandex.models.dto;

import com.example.yandex.models.Question;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
public class QuizDto {
    private String name;
    private List<Question> questions;
    private LocalDateTime start;
    private LocalDateTime end;
}
