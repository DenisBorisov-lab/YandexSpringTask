package com.example.yandex.models;

import lombok.Getter;

import java.util.UUID;

@Getter
public class EditQuestionApplication {
    private UUID id;
    private String message;
    private Type type;
}
