package models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Question {
    private UUID id;
    private String message;
    private Type type;

    public Question(){
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", type=" + type +
                '}';
    }
}
