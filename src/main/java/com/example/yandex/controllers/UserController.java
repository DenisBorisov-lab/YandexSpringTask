package com.example.yandex.controllers;

import com.example.yandex.models.dto.RunQuizDto;
import com.example.yandex.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get_quizzes")
    public @ResponseBody
    List<String> getQuizzes() {
        return personService.getQuizzes();
    }

    @GetMapping("/get_statistics/{id}")
    public @ResponseBody
    Long getStatistics(@PathVariable Long id) {
        return id;
    }

    @PostMapping("/run_quiz")
    @ResponseBody
    public void runQuiz(@RequestBody RunQuizDto runQuizDto) {
        personService.runQuiz(runQuizDto);
    }
}
