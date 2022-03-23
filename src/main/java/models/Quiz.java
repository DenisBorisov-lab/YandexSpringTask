package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class Quiz {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private LocalDateTime start;
    private final UUID id;
    @Setter
    private String name;
    @Setter
    private LocalDateTime end;
    @Setter
    private List<Question> questions;

    public Quiz(UUID id) {
        this.id = id;
    }
}
