package com.example.yandex.controllers;

import com.example.yandex.models.dto.*;
import com.example.yandex.services.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@Tag(name = "admin-controller", description = "API for admin users")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @Operation(summary = "Add quizzes to database")
    @PostMapping("/add_quiz")
    @ResponseBody
    @SneakyThrows
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "incorrect request body"),
            @ApiResponse(responseCode = "405", description = "incorrect request method")
    })
    public String addQuiz(@RequestBody List<QuizDto> quizzes) {
        adminService.addQuiz(quizzes);
        return "ok";
    }

    @Operation(summary = "Edit quiz")
    @PostMapping("/edit_quiz")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "incorrect request body"),
            @ApiResponse(responseCode = "405", description = "incorrect request method")
    })
    public String editQuiz(@RequestBody EditQuizDto application) {
        boolean result = adminService.editQuiz(application);
        if (result) {
            return "ok";
        } else {
            return "Такого опроса не было найдено";
        }

    }

    @Operation(summary = "Delete quiz")
    @PostMapping("/delete_quiz/{id}")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "incorrect request body"),
            @ApiResponse(responseCode = "405", description = "incorrect request method")
    })
    public String deleteQuiz(@PathVariable UUID id) {
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
        if (result) {
            return "ok";
        } else {
            return "Не удалось изменить вопрос!";
        }

    }

    @PostMapping("/delete_question")
    @ResponseBody
    public String delete_question(@RequestBody DeleteQuestionDto deleteQuestionDto) {
        boolean result = adminService.deleteQuestion(deleteQuestionDto);
        if (result) {
            return "ok";
        } else {
            return "Не получилось удалить вопрос";
        }
    }
}
