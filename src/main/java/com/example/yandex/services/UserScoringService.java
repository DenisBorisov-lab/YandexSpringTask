package com.example.yandex.services;

import com.example.yandex.models.Question;
import com.example.yandex.models.Quiz;
import com.example.yandex.models.UserAnswer;
import com.example.yandex.models.dto.QuizInfoDto;
import com.example.yandex.models.dto.UserAnswersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserScoringService {
    private final DataService<Quiz> dataService;

    @Autowired
    public UserScoringService(DataService<Quiz> dataService) {
        this.dataService = dataService;
    }

    public UserAnswer enrichUserAnswer(UserAnswersDto answer) {
        int score = 0;
        List<Quiz> quizzes = dataService.readValue();
        Long userId = answer.getId();
        UUID quizId = answer.getQuizId();
        List<QuizInfoDto> info = new ArrayList<>();
        Map<UUID, String> answers = answer.getAnswers();
        Set<UUID> questionIds = answers.keySet();
        for (Quiz quiz : quizzes) {
            if (quiz.getId().equals(quizId)){
                for(Question question : quiz.getQuestions()){
                    for (UUID id : questionIds){
                        if (question.getId().equals(id)){
                            if (answers.get(id).equals(question.getCorrectAnswer())){
                                score++;
                            }
                        }
                        info.add(new QuizInfoDto(question, answers.get(id)));
                    }
                }
            }
        }
        return new UserAnswer(userId, quizId, answer.getStart(), answer.getEnd(), score, info);

    }

}
