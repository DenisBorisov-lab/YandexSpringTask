package com.example.yandex.services;

import com.example.yandex.models.Quiz;
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

@Service
public class DataService implements Data {

    @Autowired
    private ObjectMapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(DataService.class);



    @Override
    public List<Quiz> readValue() {
        try {
            logger.debug("Данные из хранилища были успешно прочиатаны");
            return mapper.readValue(new File("./src/main/resources/data.json"), new TypeReference<List<Quiz>>() {
            });
        } catch (Exception ex) {
            logger.warn("Не получилось получит данные из хранилища");
            return new ArrayList<>();
        }

    }

    @Override
    public void writeValue(List<Quiz> quizzes) {
        try {
            mapper.writeValue(new File("./src/main/resources/data.json"), quizzes);
            logger.debug("Хранилище было изменено");
        } catch (Exception ex) {
            logger.error("Не получилось записать изменения в хранилище");
        }
    }
}
