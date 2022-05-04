package com.example.yandex.services;

import com.example.yandex.models.Quiz;
import com.example.yandex.models.dto.EditQuizDto;
import com.example.yandex.models.dto.QuizDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(DataService.class);
    private List<Quiz> data;


    @SneakyThrows
    public void addQuiz(List<QuizDto> quizDtos) {
        readValue();
        for (QuizDto quizDto : quizDtos) {
            data.add(new Quiz(UUID.randomUUID(), quizDto.getName(), quizDto.getQuestionDtos(), quizDto.getStart(), quizDto.getEnd()));
            logger.info("Администратор добавил квиз с названием " + quizDto.getName());
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
            logger.info("Админимтратор изменил квиз с id: " + application.getId());
            return true;
        } else {
            logger.warn("Админимтратор попытался изменить квиз с id: "
                    + application.getId()
                    + " но такого квиза не было найдено!");
            return false;
        }

    }

    public boolean deleteQuiz(UUID id) {
        readValue();
        boolean isExist = false;
        for (Quiz quiz : data) {
            if (quiz.getId().equals(id)) {
                isExist = true;
                data.remove(quiz);
                break;
            }
        }

        if (isExist) {
            writeData();
            logger.info("Админимтратор удалил квиз с id: " + id);
            return true;
        } else {
            logger.warn("Администратор поппытался удалить квиз с id: "
                    + id
                    + " Но такого квиза не было найдено!");
            return false;
        }
    }

    @SneakyThrows
    private void writeData() {
        try {
            mapper.writeValue(new File("./src/main/resources/data.json"), data);
        } catch (Exception ex) {
            logger.error("Не получилось записать изменения в хранилище");
        }

    }

    @SneakyThrows
    private void readValue() {
        try {
            logger.debug("Данные из хранилища были успешно прочиатаны");
            data = mapper.readValue(new File("./src/main/resources/data.json"), new TypeReference<List<Quiz>>() {
            });
        } catch (Exception ex) {
            logger.warn("Не получилось получит данные из хранилища");
            data = new ArrayList<>();
        }

    }
}
