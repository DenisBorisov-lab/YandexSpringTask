package com.example.yandex;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class AdminController {
    private DataService dataService;
    private ObjectMapper mapper;

    @Autowired
    public AdminController(DataService dataService, ObjectMapper mapper) {
        this.dataService = dataService;
        this.mapper = mapper;
    }

//    @GetMapping("/add_quiz")
    @PostMapping("/add_quiz")
    @ResponseBody
    @SneakyThrows

    public String addQuiz(@RequestBody List<QuizDto> quizzes, @RequestHeader ("Content-Length") int length) {
        List<QuizDto> quizDtos = new ArrayList<>();
        QuestionDto questionDto = new QuestionDto("message", Type.CHECKBOX);

        QuizDto first = new QuizDto("name", Arrays.asList(questionDto, questionDto), LocalDateTime.now(), LocalDateTime.now());
        quizDtos.add(first);
        quizDtos.add(first);
        System.out.println(mapper.writeValueAsString(quizDtos));


//        dataService.addQuiz(quiz);
        return "ok";
    }

    @PostMapping("/edit_quiz")
    @ResponseBody
    public String editQuiz(@RequestBody EditQuizApplication application) {
        return "ok";
    }

    @PostMapping("/delete_quiz")
    @ResponseBody
    public String deleteQuiz(@RequestBody String id) {
        return id;
    }

    @PostMapping("/add_question")
    @ResponseBody
    public String add_question(@RequestBody QuestionDto questionDto) {
        return "ok";
    }

    @PostMapping("/edit_question")
    @ResponseBody
    public String edit_question(@RequestBody EditQuestionApplication application) {
        return "ok";
    }

    @PostMapping("/delete_question")
    @ResponseBody
    public String delete_question(@RequestBody String id) {
        return id;
    }
}
