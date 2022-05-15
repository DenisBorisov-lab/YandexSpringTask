package com.example.yandex.services.impl;

import com.example.yandex.models.Quiz;
import com.example.yandex.services.DataService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service("dataService")
public class DataServiceServiceImpl implements DataService<Quiz> {

    private final ObjectMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(DataServiceServiceImpl.class);
    private final String path = "./src/main/resources/data.json";

    @Autowired
    public DataServiceServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Quiz> readValue() {
        try {
            logger.debug("Данные из хранилища были успешно прочиатаны");
            return mapper.readValue(new File(path), new TypeReference<List<Quiz>>() {
            });
        } catch (Exception ex) {
            logger.error("Не получилось получит данные из хранилища");
            throw new RuntimeException();
        }
    }

    @Override
    public void writeValue(List<Quiz> quizzes) {
        try {
            mapper.writeValue(new File(path), quizzes);
            logger.debug("Хранилище было изменено");
        } catch (Exception ex) {
            logger.error("Не получилось записать изменения в хранилище");
        }
    }
}
