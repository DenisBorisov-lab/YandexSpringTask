package com.example.yandex.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import com.example.yandex.models.dto.EditQuizDto;
import com.example.yandex.models.Quiz;
import com.example.yandex.models.dto.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DataService {

    @Autowired
    private ObjectMapper mapper;

    private List<Quiz> data;


    @SneakyThrows
    public void addQuiz(List<QuizDto> quizDtos) {
        readValue();
        for (QuizDto quizDto : quizDtos) {
            data.add(new Quiz(UUID.randomUUID(), quizDto.getName(), quizDto.getQuestionDtos(), quizDto.getStart(), quizDto.getEnd()));
        }
        writeData();
    }

    public boolean editQuiz(EditQuizDto application) {
        readValue();
        boolean isExist = false;
        for (Quiz quiz : data) {
            if (quiz.getId().equals(application.getId())) {
                quiz.setName(application.getName());
                quiz.setQuestions(application.getQuestions());
                isExist = true;
                break;
            }
        }

        if (isExist) {
            writeData();
            return true;
        } else {
            return false;
        }

    }

    public boolean deleteQuiz(UUID id) {
        readValue();
        boolean isExist = false;
        for (Quiz quiz : data){
            if (quiz.getId().equals(id)){
                isExist = true;
                data.remove(quiz);
            }
        }

        if(isExist){
            writeData();
            return isExist;
        }else{
            return false;
        }
    }

    @SneakyThrows
    public void writeData() {
        mapper.writeValue(new File("./src/main/resources/data.json"), data);
    }

    @SneakyThrows
    public void readValue() {
        try {
            data = mapper.readValue(new File("./src/main/resources/data.json"), new TypeReference<List<Quiz>>() {
            });
        } catch (Exception ex) {
            data = new ArrayList<>();
        }

    }
}
