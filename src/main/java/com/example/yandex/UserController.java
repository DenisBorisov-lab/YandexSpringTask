package com.example.yandex;

import models.RunQuizApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
public class UserController {

    @GetMapping("/get_quizzes")
    public String getQuizzes() {
        return "all available quizzes";
    }

    @PostMapping
    @ResponseBody
    public String runQuiz(@RequestBody RunQuizApplication application) {
        return "run";
    }

    @GetMapping("/get_statistics/{id}/{name}")
    public String getStatistics(@PathVariable Long id, String name) {
        return "ok";
    }
}
