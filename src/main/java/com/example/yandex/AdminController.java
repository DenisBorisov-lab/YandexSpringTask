package com.example.yandex;

import models.EditQuestionApplication;
import models.EditQuizApplication;
import models.Question;
import models.Quiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @PostMapping("/add_quiz")
    @ResponseBody
    public String addQuiz(@RequestBody Quiz quiz) {
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
    public String add_question(@RequestBody Question question) {
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
