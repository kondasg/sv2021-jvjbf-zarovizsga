package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.finalexam.teams.Team;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "birtdate")
    private LocalDate birthDate;
    @Enumerated(value = EnumType.STRING)
    private PositionType position;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, LocalDate birthDate, PositionType position) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
    }

    public Player(String name, LocalDate birthDate, PositionType position, Team team) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.team = team;
    }
}
