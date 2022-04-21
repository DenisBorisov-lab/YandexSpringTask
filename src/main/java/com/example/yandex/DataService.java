package com.example.yandex;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import models.QuizDto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class DataService {
    @SneakyThrows
    public void addQuiz(List<QuizDto> quizDtos) {
        ObjectMapper mapper = new ObjectMapper();
        List<QuizDto> data = mapper.readValue(new File("./src/main/resources/data.json"), new TypeReference<List<QuizDto>>() {});
        data.addAll(quizDtos);
        mapper.writeValue(new File("./src/main/resources/data.json"), quizDtos);
    }

    public void editQuiz(){

    }

    public void deleteQuiz(){
        
    }
}
