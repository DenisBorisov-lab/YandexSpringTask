package com.example.yandex.services.impl;

import com.example.yandex.models.UserAnswer;
import com.example.yandex.services.DataService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service("logDataService")
public class LogDataServiceServiceImpl implements DataService<UserAnswer> {

    private static final Logger logger = LoggerFactory.getLogger(LogDataServiceServiceImpl.class);
    private final ObjectMapper mapper;
    private final String path = "./src/main/resources/logData.json";

    @Autowired
    public LogDataServiceServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<UserAnswer> readValue() {
        try {
            logger.debug("Данные из хранилища были успешно прочиатаны");
            return mapper.readValue(new File(path), new TypeReference<List<UserAnswer>>() {
            });

        } catch (Exception ex) {
            logger.error("Не получилось получит данные из хранилища");
            throw new RuntimeException();
        }
    }

    @Override
    public void writeValue(List<UserAnswer> answers) {
        try {
            mapper.writeValue(new File(path), answers);
            logger.debug("Хранилище было изменено");
        } catch (Exception ex) {
            logger.error("Не получилось записать изменения в хранилище");
        }
    }
}
