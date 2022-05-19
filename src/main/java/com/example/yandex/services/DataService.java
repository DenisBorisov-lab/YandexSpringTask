package com.example.yandex.services;

import java.util.List;

public interface DataService<T> {
    List<T> readValue();

    void writeValue(List<T> quizzes);
}
