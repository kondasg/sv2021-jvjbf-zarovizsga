package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training360.finalexam.players.CreatePlayerCommand;
import org.training360.finalexam.players.UpdateWithExistingPlayerCommand;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/teams")
@AllArgsConstructor
public class TeamController {

    private TeamService teamService;

    @GetMapping
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO createTeam(@Valid @RequestBody CreateTeamCommand command) {
        return teamService.createTeam(command);
    }

    @PostMapping("/{id}/players")
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO createPlayerAndAddTeam(@PathVariable("id") Long id, @RequestBody CreatePlayerCommand command) {
        return teamService.createPlayerAndAddTeam(id, command);
    }

    @PutMapping("/{id}/players")
    public TeamDTO modifyPlayerTeam(@PathVariable("id") Long id, @RequestBody UpdateWithExistingPlayerCommand command) {
        return teamService.modifyPlayerTeam(id, command);
    }
}
