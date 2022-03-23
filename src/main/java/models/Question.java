package models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Question {
    private final UUID id;
    private String message;
    private Type type;

    public Question(UUID id){
        this.id = id;
    }
}
