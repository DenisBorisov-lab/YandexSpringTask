package models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class Question {
    private final UUID id;
    @Setter
    private String message;
    @Setter
    private Type type;

    public Question(UUID id){
        this.id = id;
    }
}
