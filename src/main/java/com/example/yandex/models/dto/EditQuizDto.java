package com.example.yandex.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
public class EditQuizDto {
    private  UUID id;
    private  String name;
    private  List<QuestionDto> questions;
}
