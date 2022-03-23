package com.example.yandex;

import models.Question;
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
        return null;
    }

    @PostMapping("/edit_quiz")
    public void editQuiz() {

    }

    @PostMapping("/delete_quiz")
    @ResponseBody
    public void deleteQuiz(@RequestBody String id) {

    }

    @PostMapping("/add_question")
    @ResponseBody
    public void add_question(@RequestBody Question question) {

    }

    @PostMapping("/edit_question")
    public void edit_question() {

    }

    @PostMapping("/delete_question")
    @ResponseBody
    public void delete_question(@RequestBody String id) {

    }
}
