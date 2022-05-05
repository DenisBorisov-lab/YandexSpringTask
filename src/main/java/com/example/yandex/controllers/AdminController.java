package com.example.yandex.controllers;

import com.example.yandex.models.dto.*;
import com.example.yandex.services.AdminService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/add_quiz")
    @ResponseBody
    @SneakyThrows
    public String addQuiz(@RequestBody List<QuizDto> quizzes) {
        adminService.addQuiz(quizzes);
        return "ok";
    }

    @PostMapping("/edit_quiz")
    @ResponseBody
    public String editQuiz(@RequestBody EditQuizDto application) {
        boolean result = adminService.editQuiz(application);
        if (result) {
            return "ok";
        } else {
            return "Такого опроса не было найдено";
        }

    }

    @PostMapping("/delete_quiz")
    @ResponseBody
    public String deleteQuiz(@RequestBody DeleteQuizDto deleteQuizDto) {
        UUID id = deleteQuizDto.getId();
        boolean result = adminService.deleteQuiz(id);
        if (result) {
            return "ок";
        } else {
            return "такого опроса не было найдено";
        }
    }

    @PostMapping("/add_question")
    @ResponseBody
    public String add_question(@RequestBody QuestionsDto questionDtos) {
        boolean result = adminService.addQuestions(questionDtos);
        if (result) {
            return "ok";
        } else {
            return "такого опроса не было найдено";
        }
    }

    @PostMapping("/edit_question")
    @ResponseBody
    public String edit_question(@RequestBody EditQuestionDto editQuestionDto) {
        boolean result = adminService.editQuestion(editQuestionDto);
        if (result){
            return "ok";
        }else{
            return "Не удалось изменить вопрос!";
        }

    }

    @PostMapping("/delete_question")
    @ResponseBody
    public String delete_question(@RequestBody DeleteQuestionDto deleteQuestionDto) {
        boolean result = adminService.deleteQuestion(deleteQuestionDto);
        if (result){
            return "ok";
        }else{
            return "Не получилось удалить вопрос";
        }
    }
}
