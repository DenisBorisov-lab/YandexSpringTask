package com.example.yandex.services;

import com.example.yandex.models.Question;
import com.example.yandex.models.Quiz;
import com.example.yandex.models.dto.*;
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


    public void addQuiz(List<QuizDto> quizDtos) {
        readValue();
        for (QuizDto quizDto : quizDtos) {
            data.add(new Quiz(UUID.randomUUID(), quizDto.getName(), quizDto.getQuestions(), quizDto.getStart(), quizDto.getEnd()));
            logger.info("Администратор добавил квиз с названием " + quizDto.getName());
        }
        writeData();
    }

    public boolean editQuiz(EditQuizDto application) {
        readValue();
        for (Quiz quiz : data) {
            if (quiz.getId().equals(application.getId())) {
                if (application.getName() != null) {
                    quiz.setName(application.getName());
                }
                if (application.getQuestions() != null) {
                    quiz.setQuestions(application.getQuestions());
                }
                writeData();
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
        readValue();
        for (Quiz quiz : data) {
            if (quiz.getId().equals(id)) {
                data.remove(quiz);
                writeData();
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
        readValue();
        for (Quiz quiz : data) {
            if (quiz.getId().equals(questionDtos.getQuizId())) {
                List<Question> questions = quiz.getQuestions();
                for (QuestionDto questionDto : questionDtos.getQuestions()) {
                    questions.add(new Question(UUID.randomUUID(), questionDto.getMessage(), questionDto.getCorrectAnswer()));
                    quiz.setQuestions(questions);
                }
                writeData();
                logger.info("В квиз " + questionDtos.getQuizId() + " был добавлен новый вопрос");
                return true;
            }
        }

        logger.warn("админимтратор попытался добавить новый вопрос в квиз " + questionDtos.getQuizId() + " , Но такого квиза не было найдено");
        return false;

    }

    public boolean editQuestion(EditQuestionDto editQuestionDto) {
        readValue();
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
                        writeData();
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
        readValue();
        for (Quiz quiz : data) {
            if (quiz.getId().equals(deleteQuestionDto.getQuizId())) {
                for (Question question : quiz.getQuestions()) {
                    if (question.getId().equals(deleteQuestionDto.getId())) {
                        quiz.getQuestions().remove(question);
                        writeData();
                        return true;
                    }
                }
                logger.warn("Админимтратор попытался удалить вопрос с id: " + deleteQuestionDto.getId() + " , но такой вопрос не был найден!");
            }

            logger.warn("Админимтратор попытался удалить вопрос в квизе с id: " + deleteQuestionDto.getQuizId() + " , но такого квиза не было найдено!");
        }
        return false;
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
