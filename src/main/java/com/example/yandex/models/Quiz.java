package com.example.yandex.models;

import com.example.yandex.models.dto.QuestionDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Quiz {
    private UUID id;
    private String name;
    private List<QuestionDto> questions;
    private LocalDateTime start;
    private LocalDateTime end;

}
