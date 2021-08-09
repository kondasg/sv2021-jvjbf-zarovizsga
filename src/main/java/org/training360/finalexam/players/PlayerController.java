package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/players")
@AllArgsConstructor
public class PlayerController {

    private PlayerService playerService;

    @GetMapping
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerDTO createPlayer(@Valid @RequestBody CreatePlayerCommand command) {
        return playerService.createPlayer(command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
    }
}
