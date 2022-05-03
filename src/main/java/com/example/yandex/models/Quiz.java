package com.example.yandex.models;

import com.example.yandex.models.dto.QuestionDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    private UUID id;
    private String name;
    private List<QuestionDto> questions;
    private LocalDateTime start;
    private LocalDateTime end;

}
