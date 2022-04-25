package com.example.yandex.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
public class EditQuizDto {
    private final UUID id;
    private final String name;
    private final List<QuestionDto> questions;
}
