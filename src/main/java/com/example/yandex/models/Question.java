package com.example.yandex.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private UUID id;
    private String message;
    private String correctAnswer;
    private Type type;

    @Override
    public String toString() {
        return "Question{" + "\n" +
                "message='" + message + "\n" +
                ", correctAnswer='" + correctAnswer + "\n" +
                "}";
    }
}
