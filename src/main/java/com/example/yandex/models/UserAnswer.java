package com.example.yandex.models;

import com.example.yandex.models.dto.QuizInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAnswer {
    private Long userId;
    private UUID quizId;
    private LocalDateTime start;
    private LocalDateTime end;
    private int score;
    private List<QuizInfoDto> info;

    @Override
    public String toString() {
        return "userId=" + userId + ", \n" +
                "start=" + start + ", \n" +
                "end=" + end + ", \n" +
                "score=" + score + ", \n" +
                "info=" + info;
    }
}
