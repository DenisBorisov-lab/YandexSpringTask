package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class QuizDto {
    private final String name;
    private final List<QuestionDto> questionDtos;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = JsonFormat.DEFAULT_TIMEZONE, shape = JsonFormat.Shape.STRING)
    private final LocalDateTime start;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = JsonFormat.DEFAULT_TIMEZONE, shape = JsonFormat.Shape.STRING)
    private final LocalDateTime end;

    @Override
    public String toString() {
        return "Quiz{" +
                ", name='" + name + '\'' +
                ", questions=" + questionDtos +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
