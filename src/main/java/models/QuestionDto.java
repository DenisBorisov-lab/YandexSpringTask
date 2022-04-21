package models;

import lombok.Data;

@Data
public class QuestionDto {
    private final String message;
    private final Type type;

    @Override
    public String toString() {
        return "Question{" +
                ", message='" + message + '\'' +
                ", type=" + type +
                '}';
    }
}
