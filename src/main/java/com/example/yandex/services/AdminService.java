package com.example.yandex.services;

import com.example.yandex.models.Question;
import com.example.yandex.models.Quiz;
import com.example.yandex.models.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    private Data dataService;

    public void addQuiz(List<QuizDto> quizDtos) {
        List<Quiz> data = dataService.readValue();
        for (QuizDto quizDto : quizDtos) {
            for (Question question : quizDto.getQuestions()) {
                question.setId(UUID.randomUUID());
            }
            data.add(new Quiz(UUID.randomUUID(), quizDto.getName(), quizDto.getQuestions()));
            logger.info("Администратор добавил квиз с названием " + quizDto.getName());
        }
        dataService.writeValue(data);
    }

    public boolean editQuiz(EditQuizDto application) {
        List<Quiz> data = dataService.readValue();
        for (Quiz quiz : data) {
            if (quiz.getId().equals(application.getId())) {
                if (application.getName() != null) {
                    quiz.setName(application.getName());
                }
                if (application.getQuestions() != null) {
                    quiz.setQuestions(application.getQuestions());
                }
                dataService.writeValue(data);
                logger.info("Админимтратор изменил квиз с id: " + application.getId());
                return true;
            }
        }


        logger.warn("Админимтратор попытался изменить квиз с id: "
                + application.getId()
                + " , Но такого квиза не было найдено!");
        return false;


    }

    public boolean deleteQuiz(UUID id) {
        List<Quiz> data = dataService.readValue();
        for (Quiz quiz : data) {
            if (quiz.getId().equals(id)) {
                data.remove(quiz);
                dataService.writeValue(data);
                logger.info("Админимтратор удалил квиз с id: " + id);
                return true;
            }
        }


        logger.warn("Администратор поппытался удалить квиз с id: "
                + id
                + " , Но такого квиза не было найдено!");
        return false;

    }

    public boolean addQuestions(QuestionsDto questionDtos) {
        List<Quiz> data = dataService.readValue();
        for (Quiz quiz : data) {
            if (quiz.getId().equals(questionDtos.getQuizId())) {
                List<Question> questions = quiz.getQuestions();
                for (QuestionDto questionDto : questionDtos.getQuestions()) {
                    questions.add(new Question(UUID.randomUUID(), questionDto.getMessage(), questionDto.getCorrectAnswer(), questionDto.getType()));
                    quiz.setQuestions(questions);
                }
                dataService.writeValue(data);
                logger.info("В квиз " + questionDtos.getQuizId() + " был добавлен новый вопрос");
                return true;
            }
        }

        logger.warn("админимтратор попытался добавить новый вопрос в квиз " + questionDtos.getQuizId() + " , Но такого квиза не было найдено");
        return false;

    }

    public boolean editQuestion(EditQuestionDto editQuestionDto) {
        List<Quiz> data = dataService.readValue();
        for (Quiz quiz : data) {
            if (quiz.getId().equals(editQuestionDto.getQuizId())) {
                for (Question question : quiz.getQuestions()) {
                    if (question.getId().equals(editQuestionDto.getId())) {
                        if (editQuestionDto.getMessage() != null) {
                            question.setMessage(editQuestionDto.getMessage());
                        }
                        if (editQuestionDto.getCorrectAnswer() != null) {
                            question.setCorrectAnswer(editQuestionDto.getCorrectAnswer());
                        }
                        dataService.writeValue(data);
                        logger.info("Администратор изменил вопрос с id: " + editQuestionDto.getId());
                        return true;
                    }
                }
                logger.warn("Админимтратор попытлася изменить вопрос с id: " + editQuestionDto.getId() + " , но такого вопроса не было найдено!");
            }
            logger.warn("Админимтратор попытлася добавить вопрос в квиз с id: " + editQuestionDto.getQuizId() + " , но такого квиза не было найдено!");
        }

        return false;
    }

    public boolean deleteQuestion(DeleteQuestionDto deleteQuestionDto) {
        List<Quiz> data = dataService.readValue();
        for (Quiz quiz : data) {
            if (quiz.getId().equals(deleteQuestionDto.getQuizId())) {
                for (Question question : quiz.getQuestions()) {
                    if (question.getId().equals(deleteQuestionDto.getId())) {
                        quiz.getQuestions().remove(question);
                        dataService.writeValue(data);
                        logger.info("Админимтратор удалил вопрос с id: " + deleteQuestionDto.getId());
                        return true;
                    }
                }
                logger.warn("Админимтратор попытался удалить вопрос с id: " + deleteQuestionDto.getId() + " , но такой вопрос не был найден!");
            }

            logger.warn("Админимтратор попытался удалить вопрос в квизе с id: " + deleteQuestionDto.getQuizId() + " , но такого квиза не было найдено!");
        }
        return false;
    }

}
