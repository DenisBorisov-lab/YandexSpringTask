package com.example.yandex.services;

import com.example.yandex.models.Quiz;

import java.util.List;

public interface Data {
    List<Quiz> readValue();
    void writeValue(List<Quiz> quizzes);
}
