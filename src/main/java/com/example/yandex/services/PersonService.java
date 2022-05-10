package com.example.yandex.services;

import com.example.yandex.models.Quiz;
import com.example.yandex.models.dto.RunQuizDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private Data dataService;

    public List<String> getQuizzes() {
        List<Quiz> data = dataService.readValue();
        List<String> names = new ArrayList<>();
        for (Quiz quiz : data) {
            names.add(quiz.getName());
        }

        return names;
    }


    // TODO: 07.05.2022 созранять в logData.json историю
    // TODO: 07.05.2022 проверять ответы и выдавать результат
    public int runQuiz(RunQuizDto runQuizDto) {
        return 0;
    }


}
