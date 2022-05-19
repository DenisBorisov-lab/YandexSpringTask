package com.example.yandex.models.dto;

import com.example.yandex.models.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizInfoDto {
    private Question question;
    private String givenAnswer;

    @Override
    public String toString() {
        return "QuizInfoDto{" + "\n" +
                "question=" + question + "\n" +
                ", givenAnswer='" + givenAnswer + "\n" +
                "}";
    }
}
