package com.example.yandex;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import models.Quiz;

import java.io.File;
import java.util.List;

public class DataService {
    @SneakyThrows
    public void addQuiz(List<Quiz> quizzes) {
        ObjectMapper mapper = new ObjectMapper();
        List<Quiz> data = mapper.readValue(new File("./src/main/resources/data.json"), new TypeReference<List<Quiz>>() {});
        data.addAll(quizzes);
        mapper.writeValue(new File("./src/main/resources/data.json"), quizzes);
    }

    public void editQuiz(){

    }

    public void deleteQuiz(){
        
    }
}
