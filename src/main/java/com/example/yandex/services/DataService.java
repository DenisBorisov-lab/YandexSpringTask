package com.example.yandex.services;

import com.example.yandex.models.Quiz;

import java.util.List;

public interface DataService<T> {
    List<T> readValue();
    void writeValue(List<T> quizzes);
}
