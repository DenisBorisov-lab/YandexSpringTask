package com.example.yandex;

import models.Quiz;
import models.ResponseTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {

    @PostMapping("/add_quiz")
    @ResponseBody
    public String addQuiz(@RequestBody Quiz quiz) {
        return quiz.getText();
    }

    @PostMapping("/edit_quiz")
    public void editQuiz() {

    }

    @PostMapping("/delete_quiz")
    public void deleteQuiz() {

    }

    @PostMapping("/add_question")
    public void add_question() {

    }

    @PostMapping("/edit_question")
    public void edit_question() {

    }

    @PostMapping("/delete_question")
    public void delete_question() {

    }
}
