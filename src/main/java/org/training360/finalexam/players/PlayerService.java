package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {

    private PlayerRepository playerRepository;
    private ModelMapper modelMapper;

    public List<PlayerDTO> getAllPlayers() {
        Type targetListType = new TypeToken<List<PlayerDTO>>() {}.getType();
        return modelMapper.map(playerRepository.findAll(), targetListType);
    }

    public PlayerDTO createPlayer(CreatePlayerCommand command) {
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition());
        playerRepository.save(player);
        return modelMapper.map(player, PlayerDTO.class);
    }

    public void deletePlayer(Long id) {
        getPlayerById(id);
        playerRepository.deleteById(id);
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player id not found: " + id));
    }

}
