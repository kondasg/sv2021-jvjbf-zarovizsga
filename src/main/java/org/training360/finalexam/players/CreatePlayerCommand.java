package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlayerCommand {

    @NotBlank(message = "The player name's cannot be empty")
    private String name;
    private LocalDate birthDate;
    private PositionType position;

    public CreatePlayerCommand(String name) {
        this.name = name;
    }
}
