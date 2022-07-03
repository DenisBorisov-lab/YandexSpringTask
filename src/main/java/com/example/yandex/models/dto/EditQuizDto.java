package com.example.yandex.models.dto;

import com.example.yandex.models.Question;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Getter
public class EditQuizDto {
    @NotBlank

    private UUID id;
    private String name;
    private List<Question> questions;
}
