package com.example.yandex.controllers;

import com.example.yandex.models.UserAnswer;
import com.example.yandex.models.dto.UserAnswersDto;
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
    String getStatistics(@PathVariable Long id) {
        UserAnswer statistics = personService.getStatistics(id);
        if (statistics != null){
            return statistics.toString();
        }else{
            return "Вы ещё не проходили опросов!";
        }
    }

    @PostMapping("/run_quiz")
    @ResponseBody
    public String runQuiz(@RequestBody UserAnswersDto userAnswersDto) {
        return personService.runQuiz(userAnswersDto);
    }
}
