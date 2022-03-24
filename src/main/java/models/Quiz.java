package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class Quiz {

    private final UUID id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private List<Question> questions;
    @Getter
    @Setter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private LocalDateTime start;
    @Getter
    @Setter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private LocalDateTime end;


    public Quiz(){
        this.id = UUID.randomUUID();
    }
    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
