package com.example.yandex.controllers;

import com.example.yandex.models.UserAnswer;
import com.example.yandex.models.dto.UserAnswersDto;
import com.example.yandex.services.PersonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "user-controller", description = "API for common users")
public class UserController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get_quizzes")
    public List<String> getQuizzes() {
        return personService.getQuizzes();
    }

    @GetMapping("/get_statistics/{id}")
    public List<UserAnswer> getStatistics(@PathVariable Long id) {
        return personService.getStatistics(id);
    }

    @PostMapping("/run_quiz")
    public String runQuiz(@RequestBody UserAnswersDto userAnswersDto) {
        return personService.runQuiz(userAnswersDto);
    }
}
