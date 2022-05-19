package com.example.yandex.services;

import com.example.yandex.models.Quiz;
import com.example.yandex.models.UserAnswer;
import com.example.yandex.models.dto.UserAnswersDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {

    private final Logger logger = LoggerFactory.getLogger(PersonService.class);
    @Qualifier("dataService")
    private final DataService<Quiz> dataService;
    @Qualifier("LogDataService")
    private final DataService<UserAnswer> logDataService;
    private final UserScoringService userScoringService;

    @Autowired
    public PersonService(DataService<Quiz> dataService, DataService<UserAnswer> logDataService, UserScoringService userScoringService) {
        this.dataService = dataService;
        this.logDataService = logDataService;
        this.userScoringService = userScoringService;
    }


    public List<String> getQuizzes() {
        List<Quiz> data = dataService.readValue();
        List<String> names = new ArrayList<>();
        for (Quiz quiz : data) {
            names.add(quiz.getName());
        }

        return names;
    }

    public String runQuiz(UserAnswersDto userAnswersDto) {
        List<UserAnswer> data = logDataService.readValue();
        UserAnswer answer = userScoringService.enrichUserAnswer(userAnswersDto);
        data.add(answer);
        int score = answer.getScore();
        int amountOfQuestions = answer.getInfo().size();
        logDataService.writeValue(data);
        logger.info("Пользователь " + answer.getUserId() + " прошёл опрос");
        return new StringBuilder().append(score).append(" / ").append(amountOfQuestions).toString();
    }

    public List<UserAnswer> getStatistics(Long id) {
        List<UserAnswer> data = logDataService.readValue();
        List<UserAnswer> usersAnswer = new ArrayList<>();
        for (UserAnswer answer : data) {
            if (answer.getUserId().equals(id)) {
                logger.info("Пользователь " + id + " запросил информацию о пройденных опросах");
                usersAnswer.add(answer);
            }
        }
        return usersAnswer;
    }


}
