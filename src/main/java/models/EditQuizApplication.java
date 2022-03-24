package models;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class EditQuizApplication {
    private UUID id;
    private String name;
    private List<Question> questions;
}
